<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2022/5/18
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registerJsp</title>
</head>
<body>
<form method="post" action=<%=request.getContextPath()%>/lib/checkJsp.jsp>
    <h3>I am registerJsp.jsp <br>
        name <input type="text" name="name"><br>
        class <input type="text" name="aclass"><br>
        ID <input type="text" name="id"><br>
        <input type="submit" value="Send data to server" name="submit">
    </h3>
</form>
</body>
</html>
