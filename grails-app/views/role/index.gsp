<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'role.label', default: 'Role')}"/>
    <title>Liste roles</title>
</head>

<body>
<div class="gameBox">
    <div id="list-role" class="content scaffold-list" role="main">
        <h1>Liste roles</h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <table class="table table-bordered">
            <tr>
                <th>Role</th>
            </tr>
            <g:each in="${roleList}">
                <tr>
                    <td>${it.authority}</td>
                </tr>
            </g:each>
        </table>
    </div>
</div>
</body>
</html>