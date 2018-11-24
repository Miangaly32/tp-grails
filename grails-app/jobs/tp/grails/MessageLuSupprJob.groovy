package tp.grails

class MessageLuSupprJob {
    def messageImplService
    MessageService messageService
    static triggers = {
      simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        println "Bonjour, les messages qui ont ete lu vont etre supprimer"
        def messageLus = messageImplService.getListeMessageLu()
        messageLus.each{ messageLu ->
            messageService.delete(messageLu.id)
        }
        println "Oups, les messages qui ont ete lu ont ete supprimer"
    }
}
