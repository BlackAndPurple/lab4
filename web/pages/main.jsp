<%@ page import="org.eclipse.persistence.sessions.Session" %><%--
  Created by IntelliJ IDEA.
  User: tatja
  Date: 26.01.2018
  Time: 3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Main page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"><link href='https://fonts.googleapis.com/css?family=Roboto:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" type="text/css" href="./resources/style/main_style.css">
    <!--script type="text/javascript"  src="./resources/scripts/authent_script.js"></script-->
    <script type="text/javascript"  src="./resources/scripts/main.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="./resources/style/main_style.css?version=1">
</head>
<body>

<div id="app"></div>
<%
    Cookie cookie = null;
    Cookie[] cookies = null;
    cookies = request.getCookies();
    if( cookies != null ) {
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
                if(cookie.getName().equals("login")){
                    out.println("<br>Hello, " + cookie.getValue() );
                }
        }
    }
%>
    <a href="./index" onclick="goOut()">Go out</a>
<!--script src="./public/bundle.js"></script-->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script type="text/javascript"  src="./resources/scripts/main.js"></script>

</body>
</html>
