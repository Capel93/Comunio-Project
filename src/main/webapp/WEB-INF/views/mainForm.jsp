<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title></title>
</head>
<body>
<div id="menubar">
  <ul id="menu">
    <li class="current"><a href="/api/index">Home</a></li>
    <li><a href="/api/teamSquad">Team Squad</a></li>
    <li><a href="/api/Market">Market</a></li>
    <li><a href="/api/Community">Community</a></li>

  </ul>
</div><!--close menubar-->

<form:form method="${method}" action="${action}" modelAttribute="user">
  <table>
    <tr>
      <td><form:label path="username">UserName</form:label></td>
      <td><form:input path="username"/> <i><form:errors path="username"></form:errors></i></td>
    </tr>
    <tr>
      <td><form:label path="password">E-Mail</form:label></td>
      <td><form:input path="password"/> <i><form:errors path="password"></form:errors></i></td>
    </tr>


    <tr>
      <td><input type="submit" value="Submit" /></td>
    </tr>
  </table>
</form:form>

</body>
</html>
