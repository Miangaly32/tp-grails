package tp.grails

class RecevoirMessage {
    Utilisateur destinataire
    Message message

    static constraints = {
        destinataire nullable: false
        message nullable: false
    }

    static mapping = {
        id column: 'idRecevoirMessage'
    }
}
