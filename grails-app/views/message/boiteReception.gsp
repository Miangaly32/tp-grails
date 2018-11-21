<%--
  Created by IntelliJ IDEA.
  User: Tiana
  Date: 18/11/2018
  Time: 18:12
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Boite de reception</title>
</head>

<body>
<div class="gameBox">
    <div class="gameBox__header">
        <h2>Boite de reception</h2>
    </div>
    <div class="gameBox__message">
        <ul>
            <g:if test="${listeMsgToRender.size()==0}">
                Il n'y a pas de message disponible pour le moment.
            </g:if>
            <g:each in="${listeMsgToRender}" var="msg">
                <li>
                    <a class=""><span>de:</span>${msg.auteurMessage.username}</a>
                    <p class="">${msg.contenuMessage}</p>
                </li>
            </g:each>
        </ul>
    </div>
    <a class="gameBox__btn" href="#">Ecrire un message</a>
</div>
</body>
</html>