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
    <title>Bienvenue</title>
    <asset:stylesheet src="application.css"/>
</head>

<body>

<div class="gameBox">
    <ul>
        <li>
            <g:link controller="message">Message</g:link>
        </li>
        <li>
            <g:link controller="recevoirMessage">Recevoir Message</g:link>
        </li>
        <li>
            <g:link controller="rencontre">Rencontre</g:link>
        </li>
        <li>
            <g:link controller="role">Role</g:link>
        </li>
        <li>
            <g:link controller="score">Score</g:link>
        </li>
        <li>
            <g:link controller="utilisateur">Utilisateurs</g:link>
        </li>
    </ul>
</div>

</body>
</html>