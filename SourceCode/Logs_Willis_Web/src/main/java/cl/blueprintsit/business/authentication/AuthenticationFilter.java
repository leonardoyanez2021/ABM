package cl.blueprintsit.business.authentication;

import cl.blueprintsit.beans.AuthenticationBean;
import cl.blueprintsit.business.authentication.types.Person;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Blueprints on 8/19/2015.
 */
//@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"*.xhtml","*.jsf"})
public class AuthenticationFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;


        if (  req.getRequestURI().contains("Login.xhtml") || req.getRequestURI().contains("Error.xhtml") || hasPermission(req)) {
            chain.doFilter(request, response);
        } else if(!hasPermission(req))
        {
            res.sendRedirect(req.getContextPath() + "/views/Login.xhtml");
        }
        else
        {
            res.sendRedirect(req.getContextPath() + "/views/Login.xhtml");
        }

    }

    private boolean hasPermission(HttpServletRequest req) {

        Object value = req.getSession().getAttribute(AuthenticationBean.AUTH_KEY);
        if(value == null)
            return false;


        AuthenticationBean auth = (AuthenticationBean) req.getSession().getAttribute("authenticationBean");

        Person u = auth.getLoggedUser();

        if(u == null)
            return false;

        return checkPermission(u,req.getRequestURI());

    }

    private boolean checkPermission(Person u, String requestURI) {
        if(requestURI.endsWith("/views/DBManager.xhtml") && u.getUsername().equals("1-9") || u.getUsername().equals("14751740k")){
            return true;
        }

        if(u != null && !requestURI.endsWith("/views/DBManager.xhtml"))
            return true;

        return false;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
