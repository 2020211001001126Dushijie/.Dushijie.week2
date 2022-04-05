<%--
  Created by IntelliJ IDEA.
  User: D-duo
  Date: 2022/4/5
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if (!(request.getAttribute("message")==null)) {
        out.print("<h3>" + request.getAttribute("message") + "</h3>");
    }
%>
<form method="post" action="login">
    UserName:<input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>

    <input type="submit" value="login">
</form>

<%@include file="footer.jsp"%>
