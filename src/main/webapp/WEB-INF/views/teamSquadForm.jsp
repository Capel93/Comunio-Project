<%--
  Created by IntelliJ IDEA.
  User: joanmarc
  Date: 21/05/15
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title></title>
</head>
<body>
  <c:choose>
    <c:when test="${teamSquad.getId()>0}">
      <h3>Update TeamSquad</h3>
      <c:set var="method" value="PUT"/>
      <c:set var="action" value="/api/teamSquads/${teamSquad.getId()}"/>
    </c:when>
    <c:otherwise>
      <h3>Create TeamSquad</h3>
      <c:set var="method" value="POST"/>
      <c:set var="action" value="/api/teamSquads"/>
    </c:otherwise>
  </c:choose>

  <form:form method="${method}" action="${action}" modelAttribute="teamSquad">
    <table>
      <tr>
        <td><form:label path="name">Team Squad Name</form:label></td>
        <td><form:input path="name"/> <i><form:errors path="name"></form:errors></i></td>
      </tr>
      <tr>
        <td><form:label path="titularPlayers">Titular Players</form:label></td>
      </tr>

      <c:forEach items="${teamSquad.titularPlayers}" var="player">
        <tr>
          <td><form:checkbox path="titularPlayers" value="${player}" label="${player.nick}" checked="checked"/></td>
          <td><c:out value="${player.role}" /></td>
          <td><c:out value="${player.team.name}" /></td>

        </tr>
      </c:forEach>

      <tr>
        <td><form:label path="suplentPlayers">Suplent Players</form:label></td>
      </tr>
      <c:forEach items="${teamSquad.suplentPlayers}" var="player">
        <tr>
          <td><form:checkbox path="" value="${player}" label="${player.nick}" checked="unchecked"/></td>
          <td><c:out value="${player.role}" /></td>
          <td><c:out value="${player.team.name}" /></td>

        </tr>
      </c:forEach>

      <tr>

        <td><input type="submit" value="Submit" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>
