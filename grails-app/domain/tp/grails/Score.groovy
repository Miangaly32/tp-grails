package tp.grails

class Score {
    Integer scoreJoueur
    Rencontre rencontre
    Utilisateur joueur

    static constraints = {
        scoreJoueur nullable: false, min: 0
        rencontre nullable: false
        joueur nullable: false
    }

    static mapping = {
        id column: 'idScore'
    }
}
