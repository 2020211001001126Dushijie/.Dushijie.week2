<%@include file="header.jsp"%>
<h2>Hello World!</h2>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size="30"/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
</form>
<%@include file="footer.jsp"%>
