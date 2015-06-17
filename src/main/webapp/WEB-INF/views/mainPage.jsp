<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <title>Comunio</title>

  <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
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
        <li class="current"><a href="/mainPage">Home</a></li>
        <li><a href="/users">Ranking</a></li>
        <li><a href="/teamSquads">currentRunking</a></li>
        <li><a href="/teamSquads/${user.username}">teamSquad</a></li>
        <li><a href="/market/${user.username}">Market</a></li>
      </ul>
    </div><!--close menubar-->

    <div id="site_content">



      <div id="content">
        <div class="content_item">
          <h1>Welcome To Your Website</h1>
          <p> User Name: ${user.username} </p>
          <p> Team Squad Name: ${user.teamSquad} </p>
          <p> User Email: ${user.email} </p>
          <p> User Money: ${user.money} </p>
          <p> User Points: ${user.points} </p>




        </div><!--close content_item-->
      </div><!--close content-->
    </div><!--close site_content-->



  </div><!--close main-->

<div id="footer">
  <a href="http://validator.w3.org/check?uri=referer">Valid XHTML</a> | <a href="http://fotogrph.com/">Images</a> | <a href="http://www.heartinternet.co.uk/vps/">Virtual Server</a> | website template by <a href="http://www.araynordesign.co.uk">ARaynorDesign</a>
</div><!--close footer-->
</body>
</html>
