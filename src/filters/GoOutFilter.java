package filters;

import org.eclipse.persistence.sessions.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GoOutFilter implements Filter {
    private FilterConfig filterConfig;

    public void init(final FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void doFilter(final ServletRequest request, final ServletResponse response, FilterChain chain)
            throws java.io.IOException, javax.servlet.ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession();
        String mainURI = httpReq.getContextPath() + "/main";
        String checkURI = httpReq.getContextPath() + "/check";
        boolean mainRequest = httpReq.getRequestURI().equals(mainURI);
        boolean checkRequest = httpReq.getRequestURI().equals(checkURI);
        if (!mainRequest && !checkRequest){
            if ((session.getAttribute("login") != null) && !session.getAttribute("login").equals("")){
                session.removeAttribute("login");
                session.setMaxInactiveInterval(0);
            }


        }
        chain.doFilter(request, response);
    }
}
