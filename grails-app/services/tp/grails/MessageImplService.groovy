package tp.grails

import grails.gorm.transactions.Transactional
import grails.util.Holders

@Transactional
class MessageImplService {

    MessageService messageService

    def serviceMethod() {

    }

    def ecrireMessage(String contenuMessage,Utilisateur auteur, int idDestinataire){
        Utilisateur destinataire = Utilisateur.get(idDestinataire)
        def messageEcrit = new Message(dateMessage: new Date(),flagLu: false,contenuMessage: contenuMessage,auteurMessage: auteur,destinataire: destinataire)
        messageService.save(messageEcrit)
    }
    def getListeDestinataire(Utilisateur connecter){
        List<Utilisateur> utilisateurs = Utilisateur.executeQuery('from Utilisateur u' +
                ' where u.id <> :idUser',[idUser: connecter.id])
        return utilisateurs
    }
    def getListeMessageRecu(Utilisateur connecter){
        List<Message> listesMsgRecu = Message.findAllWhere(destinataire: connecter)//to be replaced with session
        return listesMsgRecu
    }
    def getListeMessageEnvoie(Utilisateur connecter){
        List<Message> listesMsgEnvoie = Message.findAllWhere(auteurMessage: connecter)//to be replaced with session
        return listesMsgEnvoie
    }
    def getListeMessageLu(){
        List<Message> listeMsgLu = Message.findAllWhere(flagLu: true)
        return listeMsgLu
    }
    def getLoggedUser(){
        def springSecurityService = Holders.applicationContext.springSecurityService
        Utilisateur utilisateur = springSecurityService.currentUser
        return utilisateur
    }
}
