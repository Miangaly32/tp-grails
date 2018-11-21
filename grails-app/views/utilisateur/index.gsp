<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Bienvenue</title>
</head>

<body>
<div class="gameBox">
    <div class="gameBox__header">
        <h2>Bienvenue ${user.username}</h2>
    </div>
    <g:form controller="utilisateur">
        <label>Nom d'utilisateur:</label>
        <g:textField name="username" value="${user.username}"/><br/>
        <label>Mot de passe:</label>
        <g:passwordField name="password" /><br/>
        <label>Confirmation mot de passe:</label>
        <g:passwordField name="confirmPassword"/><br/>
        <g:actionSubmit action="save" value="Sauvegarder"/>
    </g:form>
</div>
</body>
</html>

