package cl.blueprintsit.auth;

import cl.blueprintsit.beans.AuthenticationBean;
import cl.blueprintsit.business.authentication.types.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Blueprints on 9/14/2015.
 */
public class AuthenticationFilter implements Filter {

    static private final Logger LOGGER = LogManager.getLogger(AuthenticationFilter.class);

    private boolean expired;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (  req.getRequestURI().contains("login.xhtml") || req.getRequestURI().contains("error.xhtml") || hasPermission(req)) {
            chain.doFilter(request, response);
        } else
        if(!hasPermission(req)) {
            res.sendRedirect(req.getContextPath() + "/view/login.xhtml");
        }
    }

    private boolean hasPermission(HttpServletRequest req) {

        Object value = req.getSession().getAttribute("app.user.name");
        LOGGER.trace("Filtrando autenticacion de usuario: " + "user" + " = " + value);
        if(value == null) {
            expired = true;
            return false;
        }

        AuthenticationBean auth = (AuthenticationBean) req.getSession().getAttribute("authenticationBean");

        Person u = auth.getLoggedUser();

        if(u == null)
            return false;

        return checkPermission(u,req.getRequestURI());

    }

    private boolean checkPermission(Person u, String requestURI) {

        LOGGER.trace("Verificando permisos de usuario " + u.getName() + " para url " + requestURI);

        if(requestURI.endsWith("/view/DBManager.xhtml") && u.getUsername().equals("1-9") || u.getUsername().equals("14751740k")){
            return true;
        }

        if(requestURI.endsWith("/view/CargarArchivo.xhtml")
                || requestURI.endsWith("/view/Configuracion.xhtml")
                || requestURI.endsWith("/view/ConsultaLog.xhtml")
                || requestURI.endsWith("/view/EnviarSFTP.xhtml")
                || requestURI.endsWith("/view/EstadoProceso.xhtml")
                || requestURI.endsWith("/view/CambioStock.xhtml")
                || requestURI.endsWith("/view/Cobranza.xhtml")
                || requestURI.endsWith("/view/UnificacionDevengo.xhtml")
                || requestURI.endsWith("/view/MantenedorTablaHomologacion.xhtml")
        )
            return true;
        else{
            return false;
        }

    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
