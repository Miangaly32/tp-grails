<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'rencontre.label', default: 'Rencontre')}" />
        <title>Liste rencontres</title>
    </head>
    <body>
        <div class="gameBox">
            <a href="#list-rencontre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
         <!--   <div class="nav" role="navigation">
                <ul>
                    <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                    <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                </ul>
            </div>-->
            <div id="list-rencontre" class="content scaffold-list" role="main">
                <h1>Liste rencontres</h1>
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
                <f:table collection="${rencontreList}" />

                <div class="pagination">
                    <g:paginate total="${rencontreCount ?: 0}" />
                </div>
            </div>
        </div>
    </body>
</html>