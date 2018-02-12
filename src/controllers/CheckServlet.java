package controllers;

import beans.ICheck;
import models.Users;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckServlet extends HttpServlet{

    @EJB
    private ICheck check;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        float x = Float.parseFloat(request.getParameter("x"));
        float y = Float.parseFloat(request.getParameter("y"));
        float r = Float.parseFloat(request.getParameter("r"));
        String login = request.getSession().getAttribute("login").toString(); //fix it
        Users user = check.findUserByLogin(login);
        boolean result = check.inArea(x, y, r);
        check.addToDB(user, x, y, r, result);

    }
}
