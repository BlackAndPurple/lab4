package filters;

import beans.ILogin;

import javax.servlet.FilterChain;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.LogRecord;


public class AccessFilter implements Filter {

    //private ILogin login;
    private FilterConfig filterConfig;

    public void init(final FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void doFilter(final ServletRequest request, final ServletResponse response, FilterChain chain)
            throws java.io.IOException, javax.servlet.ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        Cookie[] cookies = httpReq.getCookies();
        for (int  i = 0; i < cookies.length; i++){
            if (((HttpServletRequest) request).getCookies()[i].getName().equals("login") && !((HttpServletRequest) request).getCookies()[i].getValue().equals("")){
                //HttpServletResponse httpResponse = (HttpServletResponse) response;
                //response.sendRedirect("./main");
                chain.doFilter(request, response);
            }
        }
            /*if (((HttpServletRequest) request).getCookies()[0].getName().equals("login") && !((HttpServletRequest) request).getCookies()[0].getValue().equals("")){
                //request.getRequestDispatcher("/main").forward(request, response);
                //request.setAttribute("login", ((HttpServletRequest) request).getCookies()[0].getValue());
               // HttpServletResponse httpResponse = (HttpServletResponse) response;
                //httpResponse.sendRedirect("/main");
                chain.doFilter(request, response);
            }*/

        httpReq.getRequestDispatcher("/").forward(request, response); //chain.doFilter(request, response);
    }
}
