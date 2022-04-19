<%@ page import="homework.modle.User" %>
<%@ page import="jakarta.servlet.http.Cookie" %><%--
  Created by IntelliJ IDEA.
  User: D-duo
  Date: 2022/4/5
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<% User user=(User) request.getAttribute("user");%>

<h1>User Info</h1>
<%--<%--%>
<%--    Cookie[] allCookies=request.getCookies();--%>
<%--    for(Cookie c:allCookies){--%>
<%--        out.println("<br/>"+c.getName()+"---"+c.getValue());--%>
<%--    }--%>
<%--%>--%>
<%
User u=(User)session.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=u.getPassword()%></td></tr>
    <tr><td>email:</td><td><%=u.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=u.getGender()%></td></tr>
    <tr><td>Birth Date:</td><td><%=u.getBirthDate()%></td></tr>
    <tr>
        <a href="updateUser.jsp">update User</a>
    </tr>
</table>
<%@include file="footer.jsp"%>
