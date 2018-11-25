<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'rencontre.label', default: 'Rencontre')}"/>
    <title>Detail rencontre</title>
</head>

<body>
<div class="gameBox">
    <!--    <a href="#show-rencontre" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                            default="Skip to content&hellip;"/></a>
   <div class="nav" role="navigation">
               <ul>
                   <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                   <li><g:link class="list" action="index"><g:message code="default.list.label"
                                                                      args="[entityName]"/></g:link></li>
                   <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                                         args="[entityName]"/></g:link></li>
               </ul>
           </div>-->
    <div id="show-rencontre" class="content scaffold-show" role="main">
        <h1>Detail rencontre</h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <g:if test="${!score.isEmpty()}">
            <p>Date: ${score.get(0).rencontre.dateRencontre}</p>

            <table class="table table-bordered">
                <tr>
                    <th>Joueur</th>
                    <th>Score</th>
                </tr>
                <g:each in="${score}" status="i" var="s">
                    <tr>
                        <td>Joueur ${i + 1} : ${s.joueur.username}</td>
                        <td>${s.scoreJoueur}</td>

                        <g:if test="${s.estGagnant}">
                            <g:set var="gagnant" value="${s.joueur}"/>
                        </g:if>
                    </tr>
                </g:each>
            </table>

            <label>Gagnant : ${gagnant.username}</label>
        </g:if>

        <g:form resource="${this.rencontre}" method="DELETE">
            <fieldset class="buttons">
                <!-- <g:link class="edit" action="edit" resource="${this.rencontre}"><g:message
                        code="default.button.edit.label" default="Edit"/></g:link>-->
                <input class="delete" type="submit"
                       value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                       onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Etes vous sur?')}');"/>
            </fieldset>
        </g:form>
    </div>
</div>
</body>
</html>
