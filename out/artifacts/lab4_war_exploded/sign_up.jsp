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

</head>
<body>
<script src="resources/scripts/authent_script.js"></script>
<script type="text/javascript">
    function check_equals() {
        var password2 = document.getElementById("password2");
        var password1 = document.getElementById("password1");
        var error = document.getElementById("error_label");
        var button = document.getElementById("submit_button");
        if (password1.value !== password2.value){
            error.innerHTML = "incorrect password";
            button.disabled = true;
        }
        else{
            error.innerHTML = "";
            button.disabled = false;
        }
    }
    function check_login(){
        //alert("FGfxd");
        var login = document.getElementById("login");
        var error = document.getElementById("error_label1");
        var button = document.getElementById("submit_button");
        var http_request = new XMLHttpRequest();
        if (window.XMLHttpRequest) {
            http_request = new XMLHttpRequest();
        }
        http_request.open('POST', "check_login", true);
        http_request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        http_request.send("login="+login.value);
        http_request.onreadystatechange = function () {
            if(http_request.readyState === XMLHttpRequest.DONE && http_request.status === 200) {
                if (http_request.responseText === "true"){
                    error.innerHTML = "Such login already exists";
                    button.disabled = true;
                }
                else {
                    error.innerHTML = "";
                    button.disabled = false;
                }
            }
        };

    }
</script>
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
