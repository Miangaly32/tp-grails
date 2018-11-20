package tp.grails

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class UtilisateurRole implements Serializable {

	private static final long serialVersionUID = 1

	Utilisateur user
	Role role

	@Override
	boolean equals(other) {
		if (other instanceof UtilisateurRole) {
			other.userId == user?.id && other.roleId == role?.id
		}
	}

    @Override
	int hashCode() {
	    int hashCode = HashCodeHelper.initHash()
        if (user) {
            hashCode = HashCodeHelper.updateHash(hashCode, user.id)
		}
		if (role) {
		    hashCode = HashCodeHelper.updateHash(hashCode, role.id)
		}
		hashCode
	}

	static UtilisateurRole get(long userId, long roleId) {
		criteriaFor(userId, roleId).get()
	}

	static UtilisateurRole findAllByUser(Utilisateur u){
		DetachedCriteria crit = UtilisateurRole.where {
			user == Utilisateur.load(u.id)
		}
		def reps = crit.get()
	}

	static boolean exists(long userId, long roleId) {
		criteriaFor(userId, roleId).count()
	}

	private static DetachedCriteria criteriaFor(long userId, long roleId) {
		UtilisateurRole.where {
			user == Utilisateur.load(userId) &&
			role == Role.load(roleId)
		}
	}

	static UtilisateurRole create(Utilisateur user, Role role, boolean flush = false) {
		def instance = new UtilisateurRole(user: user, role: role)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(Utilisateur u, Role r) {
		if (u != null && r != null) {
			UtilisateurRole.where { user == u && role == r }.deleteAll()
		}
	}

	static int removeAll(Utilisateur u) {
		u == null ? 0 : UtilisateurRole.where { user == u }.deleteAll() as int
	}

	static int removeAll(Role r) {
		r == null ? 0 : UtilisateurRole.where { role == r }.deleteAll() as int
	}

	static constraints = {
	    user nullable: false
		role nullable: false, validator: { Role r, UtilisateurRole ur ->
			if (ur.user?.id) {
				if (UtilisateurRole.exists(ur.user.id, r.id)) {
				    return ['userRole.exists']
				}
			}
		}
	}

	static mapping = {
		id composite: ['user', 'role']
		version false
	}
}
