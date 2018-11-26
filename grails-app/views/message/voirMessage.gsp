<%--
  Created by IntelliJ IDEA.
  User: Tiana
  Date: 18/11/2018
  Time: 18:35
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Message de ${message.destinataire.username}</title>
</head>

<body>
    <div class="gameBox">
        <div class="gameBox__header">
            <h2>de : ${message.destinataire.username}</h2>
        </div>
        <p class="contentMessage">
            ${message.contenuMessage}
        </p>
        <a class="gameBox__btn" href="#">Repondre</a>
    </div>
</body>
</html>