package controllers;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import beans.*;

public class ControllerServlet extends HttpServlet{

    @EJB
    private IDataGetter dataGetter;

    private void responseBlank(HttpServletResponse resp, String content) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>" + "<head><title>result</title>" +
                "</head><body >");
        out.println("<a href=\"../\">Back</a><br>");
        out.println(content);
        out.println("</body></html>");
        out.close();
    }

    private String makeContentFromList(List ResultList){
        String retString = "";
        for (Object o : ResultList)
            retString += (o + "<br>");
        return retString;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI().substring(req.getContextPath().length());
        String[] pathArr = path.split("/");
        //responseBlank(resp, pathArr[1]);
        if (pathArr[1].equals("post_data")){
            switch (pathArr[2]){
                case "person":
                    try{
                        String name = req.getParameter("name");
                        String middleName = req.getParameter("middle_name");
                        String surname = req.getParameter("surname");
                        boolean sex = Boolean.parseBoolean(req.getParameter("sex"));
                        String date_of_birth = req.getParameter("date_of_birth");
                        Date dateOfBirth = null;
                        if ((date_of_birth != null)&& !date_of_birth.equals("") ){
                            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                            dateOfBirth = format.parse(date_of_birth);
                        }
                        dataGetter.addPerson(name, middleName, surname, sex, dateOfBirth);
                        responseBlank(resp, "Person has been added");
                    }catch(ParseException e){
                        responseBlank(resp, e.getMessage() );
                    }
                    RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
                    rd.forward(req, resp);
                    break;
                case "parent":
                    long person_id = Long.parseLong(req.getParameter("person_id"));

                    try{
                        dataGetter.addParent(person_id);
                        responseBlank(resp, "Parent has been added.");
                    } catch(EJBException e){
                        responseBlank(resp, "Unable to add parent with such person_id.");
                    }

                   // responseBlank(resp, String.valueOf(dataGetter.addParent((int)person_id)));
                    break;
                case "contacts":

                    //responseBlank(resp, String.valueOf(date));
                    try{
                        long parent_id = Long.parseLong(req.getParameter("parent_id"));
                        Date date = null;
                        try{
                            String date_of_creating = req.getParameter("date_of_creating");

                            if ((date_of_creating != null)&& !date_of_creating.equals("") ){
                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                                date = format.parse(date_of_creating);
                            }
                        }catch(ParseException e){
                            responseBlank(resp, e.getMessage() );
                        }

                        String homeAddress = req.getParameter("home_address");
                        String job = req.getParameter("job");
                        String jobPhoneNumber = req.getParameter("job_phone_number");
                        String cellPhoneNumber = req.getParameter("cell_phone_number");
                        dataGetter.addContacts(parent_id, date, homeAddress, job, jobPhoneNumber, cellPhoneNumber);
                        responseBlank(resp, "Parent's contacts have been added.");
                    }catch (Exception e){
                        responseBlank(resp, "Unable to add contacts for parent with such ID.");
                    }
                    break;
                case "kid":
                    //try{
                        long parent1_id = 0, parent2_id = 0;
                        person_id = 0;
                        try{
                            parent2_id = Long.parseLong(req.getParameter("parent2_id"));
                        }catch (NumberFormatException e){ }

                        parent1_id = Long.parseLong(req.getParameter("parent1_id"));
                        person_id = Long.parseLong(req.getParameter("person_id"));
                        //long parent1_id = Long.parseLong(req.getParameter("parent1_id"));
                        //long parent2_id = Long.parseLong(req.getParameter("parent2_id"));
                        //person_id = Long.parseLong(req.getParameter("person_id"));
                        dataGetter.addKid(person_id, parent1_id, parent2_id);
                        responseBlank(resp, "Kid has been added.");
                    /*}catch (Exception e){
                        responseBlank(resp, "Unable to add kid.");
                    }
                    */
                    break;
            }
        }
        //responseBlank(resp, req.getRequestURI().substring(req.getContextPath().length()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List ResultList = null;
        switch (req.getPathInfo()){
            case "/":
                RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
                rd.forward(req, resp);
                break;
            case "/person_type":
                responseBlank(resp, dataGetter.determineType(req.getParameter("person_id")) );
                break;
            case "/children":
                ResultList = dataGetter.getChildren(req.getParameter("parent_id"));
                responseBlank(resp, makeContentFromList(ResultList));
                break;
            case "/children_in_group":
                ResultList = dataGetter.getKidsInGroup(req.getParameter("group_name"));
                responseBlank(resp, makeContentFromList(ResultList));
                break;

            case "/people":
                ResultList = dataGetter.getPeople();
                responseBlank(resp, makeContentFromList(ResultList));
                break;
            case "/contacts":
                ResultList = dataGetter.getContacts();
                responseBlank(resp, makeContentFromList(ResultList));
                break;
            case "/parents":
                ResultList = dataGetter.getParents();
                responseBlank(resp, makeContentFromList(ResultList));
                break;
            case "/kids":
                ResultList = dataGetter.getKids();
                responseBlank(resp, makeContentFromList(ResultList));
                break;
            case "/kid_accounts":
                ResultList = dataGetter.getKidAccounts();
                responseBlank(resp, makeContentFromList(ResultList));
                break;
            case "/medinfo":
                ResultList = dataGetter.getMedInfo();
                responseBlank(resp, makeContentFromList(ResultList));
                break;
            case "/groups":
                ResultList = dataGetter.getGroups();
                responseBlank(resp, makeContentFromList(ResultList));
                break;
            case "/staff":
                ResultList = dataGetter.getStaff();
                responseBlank(resp, makeContentFromList(ResultList));
                break;
            case "/staff_group":
                ResultList = dataGetter.getStaffGroup();
                responseBlank(resp, makeContentFromList(ResultList));
                break;
        }
    }
}
