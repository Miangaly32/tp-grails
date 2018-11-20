package tp.grails

class Rencontre {
    Date dateRencontre

    static constraints = {

        dateRencontre nullable: false, blank: false
    }

    static mapping = {
        id column: 'idRencontre'
    }
}
