<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Profil</title>
</head>

<body>
<div class="gameBox">
    <div class="gameBox__header">
        <h2>Bienvenue ${user.username}</h2>
    </div>
    <g:uploadForm  controller="utilisateur">
        <g:if test="${user.featuredImageUrl}">
            <img src="${cdnRootUrl}/${cdnFolder}/${user.featuredImageUrl}" width="100"/>
        </g:if>
        <input type="file" name="featuredImageFile" />
        <br>
        <label>Nom d'utilisateur:</label>
        <g:textField name="username" value="${user.username}"/><br/>
        <g:hiddenField name="id" value="${user.id}" />
        <g:hiddenField name="version" value="${user.version}" />


        <g:actionSubmit action="save" value="Sauvegarder"/>
    </g:uploadForm >
</div>
</body>
</html>

