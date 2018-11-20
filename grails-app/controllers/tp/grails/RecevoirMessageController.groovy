package tp.grails

import grails.validation.ValidationException
import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*

class RecevoirMessageController {

    RecevoirMessageService recevoirMessageService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond recevoirMessageService.list(params), model:[recevoirMessageCount: recevoirMessageService.count()]
    }

    def show(Long id) {
        respond recevoirMessageService.get(id)
    }

    def create() {
        respond new RecevoirMessage(params)
    }

    def save(RecevoirMessage recevoirMessage) {
        if (recevoirMessage == null) {
            notFound()
            return
        }

        try {
            recevoirMessageService.save(recevoirMessage)
        } catch (ValidationException e) {
            respond recevoirMessage.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'recevoirMessage.label', default: 'RecevoirMessage'), recevoirMessage.id])
                redirect recevoirMessage
            }
            '*' { respond recevoirMessage, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond recevoirMessageService.get(id)
    }

    def update(RecevoirMessage recevoirMessage) {
        if (recevoirMessage == null) {
            notFound()
            return
        }

        try {
            recevoirMessageService.save(recevoirMessage)
        } catch (ValidationException e) {
            respond recevoirMessage.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'recevoirMessage.label', default: 'RecevoirMessage'), recevoirMessage.id])
                redirect recevoirMessage
            }
            '*'{ respond recevoirMessage, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        recevoirMessageService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'recevoirMessage.label', default: 'RecevoirMessage'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    @Secured('ROLE_USER')
    def messagesRecu(){

    }
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'recevoirMessage.label', default: 'RecevoirMessage'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
