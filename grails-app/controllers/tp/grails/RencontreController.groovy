package tp.grails

import grails.validation.ValidationException
import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*

class RencontreController {

    RencontreService rencontreService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond rencontreService.list(params), model:[rencontreCount: rencontreService.count()]
    }

    def show(Long id) {
        respond rencontreService.get(id)
    }

    def create() {
        respond new Rencontre(params)
    }

    def save(Rencontre rencontre) {
        if (rencontre == null) {
            notFound()
            return
        }

        try {
            rencontreService.save(rencontre)
        } catch (ValidationException e) {
            respond rencontre.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rencontre.label', default: 'Rencontre'), rencontre.id])
                redirect rencontre
            }
            '*' { respond rencontre, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond rencontreService.get(id)
    }

    def update(Rencontre rencontre) {
        if (rencontre == null) {
            notFound()
            return
        }

        try {
            rencontreService.save(rencontre)
        } catch (ValidationException e) {
            respond rencontre.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'rencontre.label', default: 'Rencontre'), rencontre.id])
                redirect rencontre
            }
            '*'{ respond rencontre, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        rencontreService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'rencontre.label', default: 'Rencontre'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rencontre.label', default: 'Rencontre'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    @Secured('ROLE_USER')
    def jouer(){

    }

    @Secured('ROLE_USER')
    def resultatsRencontre(){

    }
}
