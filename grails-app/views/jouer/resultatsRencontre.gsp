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
            <h1>Resultats des Jeux </h1>
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
        <p style="text-align: center">Le gagnant de cette rencontre est <strong>${scoreJoueur1ToRender.estGagnant ? scoreJoueur1ToRender.joueur.username : scoreJoueur2ToRender.joueur.username }</strong>.</p>

        <div class="gameBox__header">
            <h5>Vos rencontres récentes</h5>
        </div>
        <div>
            <g:each var="resultat" in="${resultatList}">
                <strong><g:formatDate date="${resultat.date_rencontre}" type="datetime" style="MEDIUM"/></strong><br/>
                <span class="result-player-list winner-list">${resultat.gagnant} ${resultat.scoreGagnant}</span> -  <span>${resultat.perdant} ${resultat.scorePerdant}</span><br/>
            </g:each>
        </div>
        <a class="gameBox__btn" href="index">Jouer a nouveau</a>
    </div>
</body>
</html>