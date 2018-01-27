<%--
  Created by IntelliJ IDEA.
  User: tatja
  Date: 11.01.2018
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find by group name</title>
</head>
<body>
    <form method="get" action="get_data/children_in_group">
        <label>Input ID: </label>
        <input placeholder="group_name" name="group_name">
        <button type="submit">Find</button>
    </form>
</body>
</html>
