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
        <label>Nom d'utilisateur:</label>
        <g:textField name="username"/><br/>
        <label>Mot de passe:</label>
        <g:passwordField name="password"/><br/>
        <label>Confirmation mot de passe:</label>
        <g:passwordField name="confirmPassword"/><br/>
        <g:actionSubmit action="save" value="S'inscrire"/>
    </g:form>
</div>
</body>
</html>