package tp.grails

import grails.gorm.services.Service

@Service(Rencontre)
interface RencontreService {

    Rencontre get(Serializable id)

    List<Rencontre> list(Map args)

    Long count()

    void delete(Serializable id)

    Rencontre save(Rencontre rencontre)

}