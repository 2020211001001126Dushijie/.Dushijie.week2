<%--
  Created by IntelliJ IDEA.
  User: D-duo
  Date: 2022/3/14
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>>
<form method="Post" action="/register">
    Username<input type="text" name="Username"/><br>
    password<input type="password" name="password"/><br>
    Email<input type="text" name="email"/><br>
    Gender:<input type="radio" name="gender">Male <input type="radio" name="genfer">Famale<br/>
    Date of birth:<input type="text name=" name="birthDate"><br/>
    <input type="submit" value="Redister"/>
</form>
<%@include file="footer.jsp"%>>
