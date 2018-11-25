<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Tp-Grails Application"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
</head>
<body>

    <div class="gameMenu">
        <ul>
            <li>
                <g:link href="/jouer/index" class="gameBox__btn gameBox__btn--menu active">Jouer</g:link>
            </li>
            <li>
                <a href="/message/boiteReception" class="gameBox__btn gameBox__btn--menu">Messages</a>
            </li>
            <sec:ifLoggedIn>
            <li>
                <a href="/utilisateur" class="gameBox__btn gameBox__btn--menu">Mon Profil</a>
            </li>
            </sec:ifLoggedIn>
            <li>
                <sec:ifLoggedIn>
                    <g:link controller="logout" class="gameBox__btn gameBox__btn--menu">Se déconnecter</g:link>
                </sec:ifLoggedIn>
                <sec:ifNotLoggedIn>
                    <g:link controller='login' action='auth' class="gameBox__btn gameBox__btn--menu">Se connecter</g:link>
                </sec:ifNotLoggedIn>
            </li>
        </ul>
    </div>
    <div class="gameContainer">
        <g:layoutBody/>
        <div class="gameBoxBackground">
            <asset:image class="gameBoxBackground__image" src="img_backgroud.png"/>
        </div>
    </div>


</body>
</html>
