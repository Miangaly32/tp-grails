<%--
  Created by IntelliJ IDEA.
  User: Tiana
  Date: 18/11/2018
  Time: 18:25
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Envoyer un message</title>
</head>

<body>
    <div class="gameBox">
        <form class="gameBox__form">
            <div class="gameBox__input">
                <label for="inputText">Destinataire: </label>
                <input id="inputText" type="text" placeholder="Taper le nom du joueur" />
            </div>
            <div class="gameBox__input">
                <textarea id="inputTextArea" placeholder="Ecrivez votre message ici..." style="margin: 0px; width: 326px; height: 200px;"></textarea>
            </div>
            <div class="gameBox__input submit">
                <button type="submit" class="gameBox__btn gameBox__btn--submit">Envoyer</button>
            </div>
        </form>
        <a class="gameBox__btn" href="#">Boite de reception</a>
    </div>
</body>
</html>