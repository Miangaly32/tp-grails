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
</head>

<body>
<div class="gameBox">
    <sec:ifNotGranted roles="ROLE_ADMIN">
        <div class="gameBox__header">
            <h2>Bienvenue</h2>
        </div>

        <a class="gameBox__btn gameBox__btn--large" href="jouer/jouer">COMMENCER A JOUER</a>
    </sec:ifNotGranted>
    <sec:ifNotLoggedIn>
        <a class="gameBox__btn gameBox__btn--large" href="login/auth">Se connecter</a>

        <p>Pas enconre membre? <a class="gameBox__btn gameBox__btn--link" href='/register/'>S'enregistrer</a></p>
    </sec:ifNotLoggedIn>

    <sec:ifAnyGranted roles="ROLE_ADMIN">
        <ul>

            <li>
                <g:link controller="rencontre">Rencontre</g:link>
            </li>

            <li>
                <g:link controller="role">Role</g:link>
            </li>

            <li>
                <g:link controller="utilisateur" action="list">Utilisateurs</g:link>
            </li>
        </ul>
    </sec:ifAnyGranted>
</div>
</body>
</html>