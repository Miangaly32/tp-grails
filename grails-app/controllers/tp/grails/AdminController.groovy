package tp.grails

import org.springframework.security.access.annotation.Secured

@Secured('ROLE_ADMIN')
class AdminController {

    def index() { }
}
