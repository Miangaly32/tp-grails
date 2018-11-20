package tp.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RencontreServiceSpec extends Specification {

    RencontreService rencontreService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Rencontre(...).save(flush: true, failOnError: true)
        //new Rencontre(...).save(flush: true, failOnError: true)
        //Rencontre rencontre = new Rencontre(...).save(flush: true, failOnError: true)
        //new Rencontre(...).save(flush: true, failOnError: true)
        //new Rencontre(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //rencontre.id
    }

    void "test get"() {
        setupData()

        expect:
        rencontreService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Rencontre> rencontreList = rencontreService.list(max: 2, offset: 2)

        then:
        rencontreList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        rencontreService.count() == 5
    }

    void "test delete"() {
        Long rencontreId = setupData()

        expect:
        rencontreService.count() == 5

        when:
        rencontreService.delete(rencontreId)
        sessionFactory.currentSession.flush()

        then:
        rencontreService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Rencontre rencontre = new Rencontre()
        rencontreService.save(rencontre)

        then:
        rencontre.id != null
    }
}
