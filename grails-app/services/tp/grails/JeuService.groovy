package tp.grails

import grails.gorm.transactions.Transactional
import tp.grails.Utilisateur

@Transactional
class JeuService {
    def serviceMethod() {

    }

    def jouer(Utilisateur joueur1){
        def rencontre = new Rencontre(dateRencontre: new Date())
        rencontre.save(failOnError: true)
        def joueur2 = Utilisateur.executeQuery('from Utilisateur u' +
                ' where u.username <> :username1'+
                ' order by rand()',[username1: joueur1.username,max: 1])
        def scoreJoueur1 = new Score(rencontre: rencontre,joueur: joueur1, scoreJoueur: Math.abs(new Random().nextInt() % 100) + 1)
        scoreJoueur1.save()
        def scoreJoueur2 =new Score(rencontre: rencontre,joueur: joueur2, scoreJoueur: Math.abs(new Random().nextInt() % 100) + 1)
        scoreJoueur2.save()
        if(scoreJoueur1.scoreJoueur > scoreJoueur2.scoreJoueur){
            scoreJoueur1.estGagnant = true
            scoreJoueur2.estGagnant = false
        }
        else{
            scoreJoueur1.estGagnant = false
            scoreJoueur2.estGagnant = true
        }
        [scoreJoueur1,scoreJoueur2]
    }
}
