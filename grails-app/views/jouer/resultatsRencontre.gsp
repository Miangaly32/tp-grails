<%--
  Created by IntelliJ IDEA.
  User: Tiana
  Date: 18/11/2018
  Time: 17:58
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Resultats du jeu</title>
</head>

<body>
    <div class="gameBox">
        <div class="gameBox__header">
            <h2>Resultats des Jeux </h2>
        </div>
        <div class="gameBox__result">

            <div class="result-player ${scoreJoueur1ToRender.estGagnant ? 'winner' : ''}">
                <span>${scoreJoueur1ToRender.joueur.username}</span>
                <span>${scoreJoueur1ToRender.scoreJoueur}</span>
            </div>
            <p style="font-weight: bolder">VS</p>
            <div class="result-player ${scoreJoueur2ToRender.estGagnant ? 'winner' : ''}">
                <span>${scoreJoueur2ToRender.joueur.username}</span>
                <span>${scoreJoueur2ToRender.scoreJoueur}</span>
            </div>
        </div>
        <p style="text-align: center">Le gagnant est <strong>${scoreJoueur1ToRender.estGagnant ? scoreJoueur1ToRender.joueur.username : scoreJoueur2ToRender.joueur.username }</strong>.</p>
        <a class="gameBox__btn" href="#">Jouer a nouveau</a>
    </div>
</body>
</html>