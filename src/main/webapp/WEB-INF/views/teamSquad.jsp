<%--
  Created by IntelliJ IDEA.
  User: joanmarc
  Date: 21/05/15
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>TeamSquad</title>
</head>
<body>
    <p><a href="/api/teamSquads">TeamSquad</a></p>

    <h2>Users List</h2>
    <link rel="stylesheet" href="/css/application.css">

    <div id="main">
        <div id="header">
            <div id="banner">
                <div id="welcome">
                    <h1>${user.username}</h1>
                </div><!--close welcome-->

            </div><!--close banner-->
        </div><!--close header-->

        <div id="menubar">
            <ul id="menu">
                <li ><a href="/mainPage/${user.username}">Home</a></li>
                <li><a href="/users">Ranking</a></li>
                <li><a href="/teamSquads">currentRunking</a></li>
                <li class="current"><a href="/teamSquads/${user.username}">teamSquad</a></li>
                <li><a href="/market/${user.username}">Market</a></li>
            </ul>
        </div><!--close menubar-->

        <div id="site_content">

            <div id="content">
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3">
                        <table class="table table-striped" style="width:100%; text-align:center;">
                            <thead>
                            <tr>
                                <th style="width:20%;"><h2>Nick</h2></th>
                                <th style="width:10%;"><h2>Role</h2></th>
                                <th style="width:20%;"><h2>TeamSquad</h2></th>
                                <th style="width:20%;"><h2>Team</h2></th>
                                <th style="width:20%;"><h2>TotalPoints</h2></th>

                                <th style="width:10%;"></th>
                            </tr>
                            </thead>
                            <c:forEach var="player" items="${players}">
                                <tbody>
                                <tr>
                                    <td>${player.getNick()}</td>
                                    <td>${player.getRole()}</td>
                                    <td>${player.getTeamSquad()}</td>
                                    <td>${player.getTeam()}</td>
                                    <td>${player.getCurrentPoints()}</td>
                                    <td>${player.getTotalPoints()}</td>


                                </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                        <br/><br/><br/>
                        <hr/>

                    </div>
                </div>
            </div><!--close content-->
        </div><!--close site_content-->

</body>
</html>
