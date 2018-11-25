package tp.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.core.GrailsApplication
import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.security.access.annotation.Secured

class UtilisateurController {

    UtilisateurService utilisateurService
    SpringSecurityService springSecurityService
    UploadUserFeaturedImageService uploadUserFeaturedImageService
    GrailsApplication grailsApplication

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured('ROLE_USER')
    def index() {
        Utilisateur user = springSecurityService.currentUser
        String cdnFolder = grailsApplication.config.getRequiredProperty('grails.guides.cdnFolder')
        String cdnRootUrl = grailsApplication.config.getRequiredProperty('grails.guides.cdnRootUrl')
        [user: user, cdnFolder: cdnFolder, cdnRootUrl: cdnRootUrl]
    }


    @Secured('ROLE_USER')
    def save(FeaturedImageCommand cmd) {
        Utilisateur user = springSecurityService.currentUser
        user.username = cmd.username
        user.save(flush: true)

        if (cmd.featuredImageFile != null && !cmd.featuredImageFile.empty) {
            uploadUserFeaturedImageService.uploadFeatureImage(cmd)
        }

        redirect(action: "index")
    }

    @Secured('ROLE_ADMIN')
    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        String cdnFolder = grailsApplication.config.getRequiredProperty('grails.guides.cdnFolder')
        String cdnRootUrl = grailsApplication.config.getRequiredProperty('grails.guides.cdnRootUrl')
        [utilisateurList:utilisateurService.list(params),cdnFolder:cdnFolder, cdnRootUrl:cdnRootUrl,utilisateurCount: utilisateurService.count()]
    }

    def show(Long id) {
        respond utilisateurService.get(id)
    }

    def create() {
        respond new Utilisateur(params)
    }
/*
    def save(Utilisateur utilisateur) {
        if (utilisateur == null) {
            notFound()
            return
        }

        try {
            utilisateurService.save(utilisateur)
        } catch (ValidationException e) {
            respond utilisateur.errors, view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'utilisateur.label', default: 'Utilisateur'), utilisateur.id])
                redirect utilisateur
            }
            '*' { respond utilisateur, [status: CREATED] }
        }
    }
*/

    def edit(Long id) {
        respond utilisateurService.get(id)
    }

    def update(Utilisateur utilisateur) {
        if (utilisateur == null) {
            notFound()
            return
        }

        try {
            utilisateurService.save(utilisateur)
        } catch (ValidationException e) {
            respond utilisateur.errors, view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'utilisateur.label', default: 'Utilisateur'), utilisateur.id])
                redirect utilisateur
            }
            '*' { respond utilisateur, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        utilisateurService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'utilisateur.label', default: 'Utilisateur'), id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'utilisateur.label', default: 'Utilisateur'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
