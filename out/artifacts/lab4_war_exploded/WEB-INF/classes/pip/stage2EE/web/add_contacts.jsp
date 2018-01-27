<%--
  Created by IntelliJ IDEA.
  User: tatja
  Date: 19.01.2018
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add contacts</title>
</head>
<body>
<form method="post" action="post_data/contacts">
    <h3>Adding parents' contacts </h3>
    <p>
        <label>Parent's id: </label>
        <input placeholder="not null" name="parent_id" required>
    </p>
    <p>
        <label>Date of creating: </label>
        <input name="date_of_creating" placeholder="01.01.2020">
    </p>
    <p>
        <label>Home address: </label>
        <input name="home_address">
    </p>
    <p>
        <label>Job: </label>
        <input name="job">
    </p>
    <p>
        <label>Job phone number: </label>
        <input name="job_phone_number">
    </p>
    <p>
        <label>Cell phone number: </label>
        <input name="cell_phone_number">
    </p>
    <button type="submit">Add</button>
</form>
</body>
</html>
