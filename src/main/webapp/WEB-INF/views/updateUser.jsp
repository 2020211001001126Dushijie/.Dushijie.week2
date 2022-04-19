<%--
  Created by IntelliJ IDEA.
  User: D-duo
  Date: 2022/4/19
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User u=(User)session.getAttribute("user");
%>
<form method="post" action="updateUser.jsp">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    username<input type="text" name="username" value="<%=u.getUsername()%>"/><br/>
    password<input type="password" name="password" value="<%=u.getPassword()%>"/><br/>
    Emale<input type="text" name="email" value="<%=u.getEmail()%>"/><br/>
    Gender<input type="radio" name="gender" value="male" <%="male".equals(u.getGender())?"checked":""%>>Male
    <input type="radio" name="gender" value="female" <%="female".equals(u.getGender())?"checked":""%>>Female<br/>
    Data of Birth<input type="text" name="birthdata" value="<%=u.getBirthDate()%>"/><br/>
    <input type="submit" value="Sava Change"/>

</form>
<%@include file="footer.jsp"%>