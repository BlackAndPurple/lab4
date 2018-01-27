<%--
  Created by IntelliJ IDEA.
  User: tatja
  Date: 14.01.2018
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <script src="./resources/scripts/authent_script.js"></script>
</head>
<body>

<form name="sign_up_form" method="post" action="sign_up">
    <p>
        <label>Create a login: </label>
        <input name="login" placeholder="login" id="login" onkeyup="check_login();" required>
        <label id = "error_label1"> </label>
    </p>
    <p>
        <label>Create a password: </label>
        <input name="password" placeholder="password" id="password1" required>
    </p>
    <p>
        <label>Repeat the password: </label>
        <input name="password2" placeholder="password" id="password2" onkeyup="check_equals();" required  >
        <label id = "error_label"> </label>
    </p>
    <p>
        <button type="submit" id="submit_button">Sign up</button>

    </p>

</form>
</body>
</html>
