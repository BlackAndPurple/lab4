<%--
  Created by IntelliJ IDEA.
  User: tatja
  Date: 26.01.2018
  Time: 3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <script type="text/javascript"  src="./resources/scripts/authent_script.js">
    </script>

</head>
<body>
<%
    Cookie cookie = null;
    Cookie[] cookies = null;
    cookies = request.getCookies();
    if( cookies != null ) {
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            if(cookie.getName().equals("login")){
                out.print("Hello, " + cookie.getValue() );
            }
        }
    }
%>
    <a href="./index" onclick="goOut()">Go out</a>

</body>
</html>
