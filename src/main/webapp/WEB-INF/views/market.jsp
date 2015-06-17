<%--
  Created by IntelliJ IDEA.
  User: joanmarc
  Date: 12/06/15
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><html>
<html>
<head>
  <title>Comunio</title>
  <link rel="stylesheet" href="/css/application.css">


</head>
<body>
<div id="main">
  <div id="header">
    <div id="banner">
      <div id="welcome">
        <h1>${user.username}</h1>
      </div><!--close welcome-->
      <div id="welcome_slogan">
        <h1>Comunio, by UdL</h1>
      </div><!--close welcome_slogan-->
    </div><!--close banner-->
  </div><!--close header-->

  <div id="menubar">
    <ul id="menu">
      <li class="current"><a href="/mainPage/${user.username}">Home</a></li>
      <li><a href="/users">Ranking</a></li>
      <li><a href="/teamSquads">currentRunking</a></li>
      <li><a href="/teamSquads/${user.teamSquad}">teamSquad</a></li>
      <li><a href="/market/${user.username}">Market</a></li>
    </ul>
  </div><!--close menubar-->

  <div id="site_content">

    <div id="content">
      <div class="content_item">
        <div class="well">

            <span id="user">
                    <ul id="myList">

                      <c:forEach var="player" items="${players}">
                        <form:form action="/market/${user.username}/${player.getNick()}" method="put" >
                          <li><tr><input type="checkbox" name="teamPlayers" value="${player.getNick()}"> ${player.getNick()} - ${player.getPrice()} € - ${player.getTeam()}</tr></li>
                          <td></td>
                          <input type="submit" value="Submit" />
                        </form:form>
                      </c:forEach>

                    </ul>
            </span>
        </div>

      </div><!--close content_item-->
    </div><!--close content-->
  </div><!--close site_content-->

  <script>
    function myFunction() {
      var my_players = [];
      var all_players = document.getElementsByName("teamPlayers");
      for(var i=0; i<all_players.length; i++){
        if(all_players[i].checked.toString() == "true"){
          my_players.push(all_players[i].value);
        }
      }
      var team ="Your have selected this players: ";
      for(var i=0; i<my_players.length; i++){
        team = team.concat(my_players[i] + ", ");
      }
      alert(team);
      if(my_players.length != 11){
        alert("El número de jugadors seleccionats és diferent de 11.");
        return false;
      }
      else{
        return true;
      }
    }
  </script>

</div><!--close main-->

<div id="footer">
  <a href="http://validator.w3.org/check?uri=referer">Valid XHTML</a> | <a href="http://fotogrph.com/">Images</a> | <a href="http://www.heartinternet.co.uk/vps/">Virtual Server</a> | website template by <a href="http://www.araynordesign.co.uk">ARaynorDesign</a>
</div><!--close footer-->
</body>
</html>
