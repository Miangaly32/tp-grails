package tp.grails

class MessageLuJob {
    static triggers = {
     // simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute(context) {
        def idMessageLu = context.mergedJobDataMap.get('id')
        def messageLu = Message.get(idMessageLu.toLong())
        if(!messageLu.flagLu){
            messageLu.flagLu = true
        }
        // execute job
    }
}
