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
<%
//read Cookies
    Cookie[] allCookies=request.getCookies();
    String username,password,rememberMeVal;
    if(allCookies!=null){
        for (Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("rememberMeVal")){
                rememberMeVal=c.getValue();
            }
        }//end for
    }//end if
%>
<form method="post" action="login">
    UserName:<input type="text" name="username" value="<%=username%>"><br/>
    Password:<input type="password" name="password" value="<%=password%>"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%= rememberMeVal.equals("1")?"checked":""%>/>Remember me<br/>

    <input type="submit" value="Submit"/>
</form>

<%@include file="footer.jsp"%>
