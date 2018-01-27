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
    <script type="text/javascript">
        //alert(getCookie("login"));

        function setCookie(name, value, options) {
            options = options || {};

            var expires = options.expires;

            if (typeof expires == "number" && expires) {
                var d = new Date();
                d.setTime(d.getTime() + expires * 1000);
                expires = options.expires = d;
            }
            if (expires && expires.toUTCString) {
                options.expires = expires.toUTCString();
            }

            value = encodeURIComponent(value);

            var updatedCookie = name + "=" + value;

            for (var propName in options) {
                updatedCookie += "; " + propName;
                var propValue = options[propName];
                if (propValue !== true) {
                    updatedCookie += "=" + propValue;
                }
            }

            document.cookie = updatedCookie;
        }

        function deleteCookie(name) {
            setCookie(name, "", {
                expires: -1
            })
        }

        function goOut() {
            deleteCookie("login");
            deleteCookie("password");
        }

      /*  function getCookie(name) {
            var matches = document.cookie.match(new RegExp(
                "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
            ));
            return matches ? decodeURIComponent(matches[1]) : undefined;
        }*/


    </script>
</head>
<body>
<%
    Cookie cookie = null;
    Cookie[] cookies = null;

    // Get an array of Cookies associated with the this domain
    cookies = request.getCookies();

    if( cookies != null ) {
        out.println("<h2> Found Cookies Name and Value</h2>");

        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            out.print("Hello, " + cookie.getName() + ",  ");
            out.print("Value: " + cookie.getValue( )+" <br/>");
        }
    } else {
        out.println("<h2>No cookies founds</h2>");
    }
%>
b
<button onclick="goOut()">Go out</button>

    <a href="./" onclick="goOut()">Go out</a>

</body>
</html>
