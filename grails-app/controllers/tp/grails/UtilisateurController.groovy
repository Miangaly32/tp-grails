package tp.grails

import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.security.access.annotation.Secured

class UtilisateurController {

    SpringSecurityService springSecurityService

    @Secured('ROLE_USER')
    def index() {
        Utilisateur user = springSecurityService.currentUser
        [user: user]
    }

    @Secured('ROLE_USER')
    def save() {
        Utilisateur user=springSecurityService.currentUser
        user.username=params['username']
        user.password=params['password']
        user.confirmPassword=params['confirmpassword']
        user.save(flush: true)
        redirect(action:"index")
    }
}
