package tp.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RecevoirMessageServiceSpec extends Specification {

    RecevoirMessageService recevoirMessageService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new RecevoirMessage(...).save(flush: true, failOnError: true)
        //new RecevoirMessage(...).save(flush: true, failOnError: true)
        //RecevoirMessage recevoirMessage = new RecevoirMessage(...).save(flush: true, failOnError: true)
        //new RecevoirMessage(...).save(flush: true, failOnError: true)
        //new RecevoirMessage(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //recevoirMessage.id
    }

    void "test get"() {
        setupData()

        expect:
        recevoirMessageService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<RecevoirMessage> recevoirMessageList = recevoirMessageService.list(max: 2, offset: 2)

        then:
        recevoirMessageList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        recevoirMessageService.count() == 5
    }

    void "test delete"() {
        Long recevoirMessageId = setupData()

        expect:
        recevoirMessageService.count() == 5

        when:
        recevoirMessageService.delete(recevoirMessageId)
        sessionFactory.currentSession.flush()

        then:
        recevoirMessageService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        RecevoirMessage recevoirMessage = new RecevoirMessage()
        recevoirMessageService.save(recevoirMessage)

        then:
        recevoirMessage.id != null
    }
}
