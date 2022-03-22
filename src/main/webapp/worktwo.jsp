<%--
  Created by IntelliJ IDEA.
  User: D-duo
  Date: 2022/3/9
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="/weektwo" method="GET" >
            Username: <input type="text" name="name">
            <br />
            Password: <input type="text" name="password" />
            <br />
            Email: <input type="text" name="" />
            <br />
            Data of birth: <input type="text" name="" />

        </form>
        <form method="post" action="/weektwo">
            <input type="radio" name="sex" <c:if test="${param.sex== '男'}""</c:if>>男
            <input type="radio" name="sex" <c:if test="${param.sex== '女'}""</c:if>>女
        </form>
        <input type="submit" value="提交" />
    <div>
</body>
</html>
