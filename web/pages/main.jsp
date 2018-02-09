<%@ page import="org.eclipse.persistence.sessions.Session" %><%--
  Created by IntelliJ IDEA.
  User: tatja
  Date: 26.01.2018
  Time: 3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%
    Cookie cookie = null;
    Cookie[] cookies = null;
    cookies = request.getCookies();
    String name = null;
    if( cookies != null ) {
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            if(cookie.getName().equals("login")){
                name = cookie.getValue();
            }
        }
    }
%>
<html>
<head>
    <title>Main page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" type="text/css" href="./resources/style/main_page_style.css">
    <link href="./resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
    <script type="text/javascript"  src="./resources/scripts/main.js"></script>

</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                    <a id="log-out" href="./index" onclick="goOut()" ><span class="glyphicon glyphicon-off"></span> Log out</a>
            </button>
            <a class="navbar-brand" >Tatiana Fomina, Lab4 v9658</a>
        </div>
        <div class="collapse navbar-collapse">

            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a disabled>Hello, <%=name%></a> </li>
                <li><a href="./index" onclick="goOut()" ><span class="glyphicon glyphicon-off"></span> Log out</a></li>
            </ul>
        </div>
    </div>
</div>

<div class = "container-fluid">

    <div class="row">
        <div class="col-sm-6" id="left_column">
            <div id="plot-container">
                <div class="col-sm-12" id="my-plot"></div>
            </div>

        </div>
        <div class="col-sm-6">Second column</div>
    </div>
</div>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script type="text/javascript"  src="./resources/scripts/main.js"></script>

</body>
</html>
