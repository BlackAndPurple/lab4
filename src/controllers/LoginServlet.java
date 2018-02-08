package controllers;

import beans.ILogin;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    @EJB
    private ILogin login;



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loginStr;
        String password;
        String path = request.getRequestURI().substring(request.getContextPath().length());

        String[] pathArr = path.split("/");
        switch (pathArr[1]){
            case "sign_up":
                login.addUser(request.getParameter("login"), request.getParameter("password"));
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html>" + "<head><title>result</title>" +
                        "</head><body >");
                out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +  "/resources/style/authent_style.css' />");
                out.println("<div id=\"response\"><h1>You've successfully signed up</h1><br>");
                out.println("<h2><a href=\"./index\">Sign in to continue</a></h2><br></div>");
                out.println("</body></html>");
                out.close();

                break;
            case "sign_in":
                loginStr = request.getParameter("login");
                password = request.getParameter("password");
                if (!login.userExists(loginStr, password)){
                    request.setAttribute("userExists", "false");
                    request.getRequestDispatcher("/index").forward(request, response);
                }

                Cookie cookieLogin = new Cookie("login", loginStr);
                cookieLogin.setMaxAge(60*60);
                response.addCookie(cookieLogin);
                response.sendRedirect("./main");
                break;

            case "check_user":
                loginStr = request.getParameter("login");
                password = request.getParameter("password");
                response.setContentType("text/plain;charset=UTF-8");
                response.setHeader("Access-Control-Allow-Origin", "*");
                try  {
                    PrintWriter out1 = response.getWriter();
                    String stringResponse = String.valueOf(login.userExists(loginStr, password));
                    out1.print(stringResponse);
                    out1.flush();
                }catch (Exception e){}
                break;

            case "check_login":
                loginStr = request.getParameter("login");
                response.setContentType("text/plain;charset=UTF-8");
                response.setHeader("Access-Control-Allow-Origin", "*");

                try  {
                    PrintWriter out1 = response.getWriter();
                    String stringResponse = String.valueOf(login.loginExists(loginStr));
                    out1.print(stringResponse);
                    out1.flush();
                }catch (Exception e){}
                break;

        }


    }


}
