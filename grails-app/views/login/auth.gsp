<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Connexion</title>
</head>

<body>
<div class="gameBox">
    <h1>Connexion</h1>
    <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" class="cssform" autocomplete="off">
        <p>
            <label for="username">Nom d'utilisateur:</label>
            <input type="text" class="text_" name= "${usernameParameter ?:'username'}" id="username"/>
        </p>

        <p>
            <label for="password">Mot de passe:</label>
            <input type="password" class="text_" name='${passwordParameter ?:'password'}' id="password"/>
        </p>

        <p>
            <input class="gameBox__btn" type="submit" id="submit" value="Se connecter"/>
        </p>
    </form>
</div>
</body>
</html>