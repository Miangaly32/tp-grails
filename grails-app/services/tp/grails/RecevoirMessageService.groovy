package tp.grails

import grails.gorm.services.Service

@Service(RecevoirMessage)
interface RecevoirMessageService {

    RecevoirMessage get(Serializable id)

    List<RecevoirMessage> list(Map args)

    Long count()

    void delete(Serializable id)

    RecevoirMessage save(RecevoirMessage recevoirMessage)

}