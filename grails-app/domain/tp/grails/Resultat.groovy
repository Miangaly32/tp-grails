package tp.grails

class Resultat {
    int idGagnant
    String gagnant
    int scoreGagnant
    int idPerdant
    String perdant
    int scorePerdant
    Date date_rencontre

    static mapping = {
        table "listeresultat"
        id name: 'date_rencontre'
        version false
        id generator: 'assigned'
        columns {
            idGagnant column: "idGagnant"
            gagnant column: "gagnant"
            scoreGagnant column: "scoreGagnant"
            idPerdant column: "idPerdant"
            perdant column: "perdant"
            scorePerdant column: "scorePerdant"
            date_rencontre column: "date_rencontre"
        }

    }
}
