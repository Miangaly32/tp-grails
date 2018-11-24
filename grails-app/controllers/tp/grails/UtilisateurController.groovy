package tp.grails

import grails.core.GrailsApplication
import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.security.access.annotation.Secured


class UtilisateurController {

    SpringSecurityService springSecurityService
    UploadUserFeaturedImageService uploadUserFeaturedImageService
    GrailsApplication grailsApplication

    @Secured('ROLE_USER')
    def index() {
        Utilisateur user = springSecurityService.currentUser
        String cdnFolder =  grailsApplication.config.getRequiredProperty('grails.guides.cdnFolder')
        String cdnRootUrl=  grailsApplication.config.getRequiredProperty('grails.guides.cdnRootUrl')
        [user: user,cdnFolder: cdnFolder,cdnRootUrl: cdnRootUrl]
    }

    @Secured('ROLE_USER')
    def save(FeaturedImageCommand cmd) {
        Utilisateur user = springSecurityService.currentUser
        user.username=cmd.username
        user.save(flush: true)

        if (cmd.featuredImageFile!=null && !cmd.featuredImageFile.empty) {
            uploadUserFeaturedImageService.uploadFeatureImage(cmd)
        }

        redirect(action:"index")
    }


}
