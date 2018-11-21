package tp.grails

import org.springframework.security.access.annotation.Secured

class JouerController {

    def jeuService

    @Secured('ROLE_USER')
    def index() { }

    @Secured('ROLE_USER')
    def jouer(){
        List<Score> listScore = jeuService.jouer(Utilisateur.findById(2))
        chain(action: "resultatsRencontre", model: [scoreJoueur1: listScore.get(0),scoreJoueur2: listScore.get(1)])
    }

    @Secured('ROLE_USER')
    def resultatsRencontre(){
        def scoreJoueur1 = chainModel['scoreJoueur1']
        def scoreJoueur2 = chainModel['scoreJoueur2']
        render(view: "/jouer/resultatsRencontre",model: [scoreJoueur1ToRender: scoreJoueur1,scoreJoueur2ToRender: scoreJoueur2])
    }
}
