<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>

<p><a href="/api/users">Users</a></p>

<c:if test="${not empty user}">
    <h2>User ${user.username}</h2>
    <c:if test="${not empty user.email}">
        <p>E-mail: ${user.getEmail()}</p>
    </c:if>
    <c:if test="${not empty user.getCommunity()}">
        <p Community:${user.getCommunity()}/>
    </c:if>
    <c:if test="${not empty user.getTeamSquad()}">
        <p TeamSquad:${user.getTeamSquad()}/>
    </c:if>
</c:if>

<p><a href="/api/teamSquads/${user.getTeamSquad()}/teamSquadForm/">Update Team Squad</a></p>

</body>
</html>
