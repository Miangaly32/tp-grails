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
        def listeDestinataire = messageImplService.getListeDestinataire(3)
        render(view: "envoyerMessage",model: [listeDestToRender: listeDestinataire])
    }

    @Secured('ROLE_USER')
    def envoi(){
        def contenuMessage = params["contenuMessage"]
        int destinataire = params["destinataire"] as Integer
        messageImplService.ecrireMessage(contenuMessage,3,destinataire)
        redirect action: "boiteEnvoi"
    }

    @Secured('ROLE_USER')
    def voirMessage(){

    }

    @Secured('ROLE_USER')
    def boiteReception(){
        List<RecevoirMessage> listesRecevoirMessage = RecevoirMessage.findAllWhere(destinataire: Utilisateur.get(3))//to be replaced with session
        List<Message> listesMsgRecu = new ArrayList<Message>()
        for(RecevoirMessage msgR : listesRecevoirMessage){
            listesMsgRecu.add(msgR.message)
        }
        [listeMsgToRender: listesMsgRecu]
    }

    @Secured('ROLE_USER')
    def boiteEnvoi(){
        List<Message> listesMsgEnvoie = Message.findAllWhere(auteurMessage: Utilisateur.get(3))//to be replaced with session
        [listeMsgToRender: listesMsgEnvoie]
    }

    def show(Long id) {
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
