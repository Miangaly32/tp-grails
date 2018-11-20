package tp.grails

import org.springframework.security.access.annotation.Secured

class RegisterController {

    @Secured('permitAll')
    def index() {}

    @Secured('permitAll')
    def save() {
        def utilisateur = new Utilisateur(params)
        if (utilisateur.save())
            render 'success'
    }
}
