package tp.grails

import grails.gorm.transactions.Transactional

@Transactional
class MessageImplService {

    MessageService messageService
    RecevoirMessageService recevoirMessageService
    def serviceMethod() {

    }

    def ecrireMessage(String contenuMessage,int idAuteur, int idDestinataire){
        Utilisateur auteur = Utilisateur.get(idAuteur)
        Utilisateur destinataire = Utilisateur.get(idDestinataire)
        def messageEcrit = new Message(dateMessage: new Date(),flagLu: false,contenuMessage: contenuMessage,auteurMessage: auteur)
        messageService.save(messageEcrit)
        def recevoirMsg = new RecevoirMessage(message: messageEcrit,destinataire: destinataire)
        recevoirMessageService.save(recevoirMsg)
    }
    def getListeDestinataire(int idConnecter){
        List<Utilisateur> utilisateurs = Utilisateur.executeQuery('from Utilisateur u' +
                ' where u.id <> :idUser',[idUser: idConnecter.toLong()])
        return utilisateurs
    }
}
