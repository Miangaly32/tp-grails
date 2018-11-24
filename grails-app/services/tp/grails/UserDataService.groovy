package tp.grails

import grails.gorm.services.Service

@SuppressWarnings(['LineLength', 'UnusedVariable', 'SpaceAfterOpeningBrace', 'SpaceBeforeClosingBrace'])
@Service(Utilisateur)
interface UserDataService {

    Utilisateur get(Long id)

    List<Utilisateur> list(Map args)

    Number count()

    void delete(Serializable id)

    Utilisateur save(String username)

    Utilisateur updateName(Serializable id, Long version, String username)

    Utilisateur updateFeaturedImageUrl(Serializable id, Long version, String featuredImageUrl)
}
