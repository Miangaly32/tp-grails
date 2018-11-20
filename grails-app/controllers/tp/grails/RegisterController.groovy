package tp.grails

import org.springframework.security.access.annotation.Secured

class RegisterController {

    @Secured('permitAll')
    def index() {}

    @Secured('permitAll')
    def save() {
        Utilisateur utilisateur = new Utilisateur(params)
        utilisateur.save()
        Role role = Role.findByAuthority('ROLE_USER')
        UtilisateurRole userRole = new UtilisateurRole(user: utilisateur, role: role)
        userRole.save(flush: true, failOnError: true)
        redirect(controller:"login")
    }
}
