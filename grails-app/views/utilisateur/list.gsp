<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'utilisateur.label', default: 'Utilisateur')}"/>
    <title>Liste utilisateurs</title>
</head>

<body>
<div class="gameBox">
    <div id="list-role" class="content scaffold-list" role="main">
        <h1><g:message code="default.list.label" args="[entityName]"/></h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <table class="table table-bordered">
            <tr>
                <th>Photo</th>
                <th>Nom d'utilisateur</th>
            </tr>
                <g:each in="${utilisateurList}">
                <tr>
                    <td>
                        <g:if test="${it.featuredImageUrl}">
                            <img src="${cdnRootUrl}/${cdnFolder}/${it.featuredImageUrl}" width="60"/>
                        </g:if>
                    </td>
                    <td>${it.username}</td>
                </tr>
            </g:each>
        </table>


        <div class="pagination">
            <g:paginate total="${utilisateurCount ?: 0}"/>
        </div>
    </div>
</div>
</body>
</html>