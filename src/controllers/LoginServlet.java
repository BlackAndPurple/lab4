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
        String path = request.getRequestURI().substring(request.getContextPath().length());
        String[] pathArr = path.split("/");
        switch (pathArr[1]){
            case "sign_up":
                login.addUser(request.getParameter("login"), request.getParameter("password"));
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html>" + "<head><title>result</title>" +
                        "</head><body >");
                out.println("You've successfully signed up<br>");
                out.println("<a href=\"./\">Sign in to continue</a><br>");
                out.println("</body></html>");
                out.close();

                break;
            case "sign_in":
                loginStr = request.getParameter("login");
                String password = request.getParameter("password");
                if (!login.userExists(loginStr, password)){
                    request.setAttribute("userExists", "false");
                    request.getRequestDispatcher("/").forward(request, response);
                }

                Cookie cookieLogin = new Cookie("login", loginStr);
                cookieLogin.setMaxAge(60*60);
                response.addCookie(cookieLogin);
                //request.getRequestDispatcher("/main").forward(request, response);
               // HttpServletResponse httpResponse = (HttpServletResponse) response;
                response.sendRedirect("./main");
                //request.getRequestDispatcher("/main").forward(request, response);

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

       /* response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>" + "<head><title>result</title>" +
                "</head><body >");
        out.println("<a href=\"./\">Back</a><br>");
        out.println(request.getPathInfo());
        out.println("</body></html>");
        out.close();
*/
    }


}
