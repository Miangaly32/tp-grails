package tp.grails

class Message {
    Date dateMessage
    String contenuMessage
    Boolean flagLu
    Utilisateur auteurMessage
    Utilisateur destinataire

    static belongsTo = [RecevoirMessage]

    static constraints = {
        dateMessage nullable: false, blank: false
        contenuMessage nullable: false, blank: true
        auteurMessage nullable: false
        destinataire nullable: false
    }
    static mapping = {
        id column:  'idMessage'
        cache true
    }
}
