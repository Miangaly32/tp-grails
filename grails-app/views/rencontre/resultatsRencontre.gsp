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
            <div class="result-player">
                <span>Joueur 1</span>
                <span>10</span>
            </div>
            <p style="font-weight: bolder">VS</p>
            <div class="result-player winner">
                <span>Joueur 2</span>
                <span>30</span>
            </div>
        </div>
        <p style="text-align: center">Le gagnant est le <strong>Joueur 2</strong>.</p>
        <a class="gameBox__btn" href="#">Jouer a nouveau</a>
    </div>
</body>
</html>