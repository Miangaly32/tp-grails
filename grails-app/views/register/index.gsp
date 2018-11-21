<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Inscription</title>
</head>

<body>
<div class="gameBox">
    <h1>Inscription</h1>
    <g:form controller="register" >
        <div class="gameBox__input">
            <label>Nom d'utilisateur:</label>
            <g:textField name="username" required="true"/>
        </div>
        <div class="gameBox__input">
            <label>Mot de passe:</label>
            <g:passwordField name="password" required="true"/>
        </div>
        <div class="gameBox__input">
            <label>Confirmer votre mot de passe:</label>
            <g:passwordField name="confirmPassword" required="true"/>
        </div>
        <g:actionSubmit class="gameBox__btn gameBox__btn--submit" action="save" value="S'inscrire"/>
        <p>Deja membre? <a class="gameBox__btn gameBox__btn--link" href='/login/auth'>Se connecter</a> </p>
    </g:form>
</div>
</body>
</html>