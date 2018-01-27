<%--
  Created by IntelliJ IDEA.
  User: tatja
  Date: 19.01.2018
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add parent</title>
</head>
<body>
<form method="post" action="post_data/parent">
    <h3>Adding a new parent </h3>
    <p>
        <label>Person ID: </label>
        <input placeholder="not null" name="person_id" required>
    </p>
    <button type="submit">Add</button>
</form>
</body>
</html>
