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

    private FilterConfig filterConfig;

    public void init(final FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void doFilter(final ServletRequest request, final ServletResponse response, FilterChain chain)
            throws java.io.IOException, javax.servlet.ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;
        Cookie[] cookies = httpReq.getCookies();
        String loginURI = httpReq.getContextPath() + "/index";
        boolean loginCookieFound = false;
        for (int  i = 0; i < cookies.length; i++){
            if (((HttpServletRequest) request).getCookies()[i].getName().equals("login") && !((HttpServletRequest) request).getCookies()[i].getValue().equals("")){
                loginCookieFound = true;
            }
        }
        boolean loginRequest = httpReq.getRequestURI().equals(loginURI);
        if (loginCookieFound || loginRequest) {
            chain.doFilter(request, response);
        } else {
            httpResp.sendRedirect(loginURI);
        }

    }
}
