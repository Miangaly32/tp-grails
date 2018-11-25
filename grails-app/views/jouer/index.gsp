<%--
  Created by IntelliJ IDEA.
  User: Tiana
  Date: 18/11/2018
  Time: 11:49
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Jouer</title>
</head>

<body>
    <div class="gameBox">
        <div class="gameBox__header">
            <h2>Bienvenue, ${utilisateur.username}</h2>
        </div>
        <g:form controller="jouer" action="jouer" >
            <g:actionSubmit class="gameBox__btn gameBox__btn--large" action="jouer" value="COMMENCER A JOUER"/>
        </g:form>
        <p style="text-align: center">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
</body>
</html>