package tp.grails

import org.springframework.security.access.annotation.Secured
import grails.validation.ValidationException
import java.util.List

import static org.springframework.http.HttpStatus.*

class MessageController {

    MessageService messageService
    MessageImplService messageImplService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond messageService.list(params), model:[messageCount: messageService.count()]
    }

    @Secured('ROLE_USER')
    def envoyerMessage(){
        def listeDestinataire = messageImplService.getListeDestinataire(messageImplService.getLoggedUser())
        render(view: "envoyerMessage",model: [listeDestToRender: listeDestinataire])
    }

    @Secured('ROLE_USER')
    def envoi(){
        def contenuMessage = params["contenuMessage"]
        int destinataire = params["destinataire"] as Integer
        messageImplService.ecrireMessage(contenuMessage,messageImplService.getLoggedUser(),destinataire)
        redirect action: "boiteEnvoi"
    }

    @Secured('ROLE_USER')
    def voirMessage(){
        def id = params['idMsg']
        def message = Message.get(id)
        if(message.destinataire.id == messageImplService.getLoggedUser().id || message.auteurMessage.id == messageImplService.getLoggedUser().id){
            MessageLuJob.triggerNow([id:id])
            render(view: "voirMessage",model: [message: message])
        }
    }

    @Secured('ROLE_USER')
    def boiteReception(){
        Utilisateur uConnecter = messageImplService.getLoggedUser()
        List<Message> listesMsgRecu = messageImplService.getListeMessageRecu(uConnecter)
        [listeMsgToRender: listesMsgRecu]
    }

    @Secured('ROLE_USER')
    def boiteEnvoi(){
        Utilisateur uConnecter = messageImplService.getLoggedUser()
        List<Message> listesMsgEnvoie = messageImplService.getListeMessageEnvoie(uConnecter)
        [listeMsgToRender: listesMsgEnvoie]
    }

    @Secured('ROLE_USER')
    def show() {
        def id = params['idMsg']
        respond messageService.get(id)
    }

    def create() {
        respond new Message(params)
    }

    def save(Message message) {
        if (message == null) {
            notFound()
            return
        }

        try {
            messageService.save(message)
        } catch (ValidationException e) {
            respond message.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'message.label', default: 'Message'), message.id])
                redirect message
            }
            '*' { respond message, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond messageService.get(id)
    }

    def update(Message message) {
        if (message == null) {
            notFound()
            return
        }

        try {
            messageService.save(message)
        } catch (ValidationException e) {
            respond message.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'message.label', default: 'Message'), message.id])
                redirect message
            }
            '*'{ respond message, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        messageService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'message.label', default: 'Message'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'message.label', default: 'Message'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
