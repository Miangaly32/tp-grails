<%--
  Created by IntelliJ IDEA.
  User: Tiana
  Date: 18/11/2018
  Time: 18:25
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Envoyer un message</title>
</head>

<body>
    <div class="gameBox">
        <g:form class="gameBox__form" action="envoi" controller="message">
            <div class="gameBox__input">
                <label for="destinataire">Destinataire: </label>
                <g:select id="destinataire" name='destinataire'
                          noSelection="${['null':'Selectionner un destinataire...']}"
                          from='${listeDestToRender}'
                          optionKey="id" optionValue="username" required="true" />
            </div>
            <div class="gameBox__input">
                <textarea name="contenuMessage" id="inputTextArea" placeholder="Ecrivez votre message ici..." style="margin: 0px; width: 326px; height: 200px;"></textarea>
            </div>
            <div class="gameBox__input submit">
                <g:submitButton name="envoie" class="gameBox__btn gameBox__btn--submit" value="Envoyer"/>
            </div>
        </g:form>
        <a class="gameBox__btn" href="boiteReception">Boite de reception</a>
    </div>
</body>
</html>