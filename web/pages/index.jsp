<%--
  Created by IntelliJ IDEA.
  User: tatja
  Date: 14.01.2018
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Lab4</title>

  </head>
  <body>
    <form name="sign_in_form" method="post" action="sign_in">
        <p>
            ${userExists == "false" ? 'Login or password is incorrect. <br>Please, try again' : ''}
        </p>
        <p>
            <label>Enter your login: </label>
            <input name="login" placeholder="login" required>
        </p>
        <p>
            <label>Enter your password: </label>
            <input name="password" placeholder="password" required>
        </p>
        <p>
            <button type="submit">Sign in</button>
            <a href="register">Sign up</a>
        </p>

    </form>
  </body>
</html>
