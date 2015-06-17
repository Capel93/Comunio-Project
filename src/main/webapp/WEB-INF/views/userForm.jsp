<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <title>User Form</title>
</head>
<body>

<c:choose>
  <c:when test="${user.username!=null}">
    <h3>Update Greeting</h3>
    <c:set var="method" value="PUT"/>
    <c:set var="action" value="/api/users/${user.username}"/>
  </c:when>
  <c:otherwise>
    <h3>Create Greeting</h3>
    <c:set var="method" value="POST"/>
    <c:set var="action" value="/api/users"/>
  </c:otherwise>
</c:choose>

<form:form method="${method}" action="${action}" modelAttribute="user">
  <table>
    <tr>
      <td><form:label path="username">UserName</form:label></td>
      <td><form:input path="username"/> <i><form:errors path="username"></form:errors></i></td>
    </tr>
    <tr>
      <td><form:label path="email">E-Mail</form:label></td>
      <td><form:input path="email"/> <i><form:errors path="email"></form:errors></i></td>
    </tr>
    <tr>
      <td><form:label path="community">Community</form:label></td>
      <td><form:input path="community"/> <i><form:errors path="community"></form:errors></i></td>
    </tr>
    <tr>
      <td><form:label path="teamSquad">Team Squad</form:label></td>
      <td><form:input path="teamSquad"/> <i><form:errors path="teamSquad"></form:errors></i></td>
    </tr>

    <tr>
      <td><input type="submit" value="Submit" /></td>
    </tr>
  </table>
</form:form>

</body>
</html>