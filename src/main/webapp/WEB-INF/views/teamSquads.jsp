<%--
  Created by IntelliJ IDEA.
  User: joanmarc
  Date: 21/05/15
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="../css/application.css">

</head>
<body>
  <h2>TeamSquad List</h2>
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
        <li><a href="/mainPage">Home</a></li>
        <li><a href="/users">Ranking</a></li>
        <li class="current"><a href="/teamSquads">currentRunking</a></li>
        <li><a href="/teamSquads/${user.username}">teamSquad</a></li>
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
                <th style="width:20%;"><h2>ID</h2></th>
                <th style="width:10%;"><h2>Name</h2></th>
                <th style="width:20%;"><h2>Manager</h2></th>
                <th style="width:20%;"><h2>Points</h2></th>

                <th style="width:10%;"></th>
              </tr>
              </thead>
              <c:forEach var="teamSquad" items="${teamSquads}">
                <tbody>
                <tr>
                  <td><a href="/teamSquads/${teamSquad.getId()}">${teamSquad.getId()}</a></td>
                  <td>${teamSquad.getName()}</td>
                  <td>${teamSquad.getManager()}</td>
                  <td>${teamSquad.getPoints()}</td>

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



  </div><!--close main-->



</body>
</html>
