package tp.grails

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class Utilisateur implements Serializable {

    static transients = [ "confirmPassword" ]

    private static final long serialVersionUID = 1

    String username
    String password
    String confirmPassword
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

   Set<Role> getAuthorities() {
        (UtilisateurRole.findAllByUser(this) as List<UtilisateurRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
    }

    static mapping = {
        password column: '`password`'
        id column: '`idUtilisateur`'
        confirmPassword validator: { String val, Utilisateur obj, errors ->
            if (!(obj.confirmPassword == val)) errors.rejectValue('password', 'noMatch')
        }

    }
}
