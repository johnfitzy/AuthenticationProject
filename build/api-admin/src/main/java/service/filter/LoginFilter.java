package service.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.properties.AppProperties;


@WebFilter(filterName = "LogonFilter")
public class LoginFilter implements Filter {

    private FilterConfig config;

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        String loginURI = request.getContextPath() + "/" + AppProperties.getInstance().getProperty("login_page");

        boolean loggedIn = session != null && session.getAttribute(AppProperties.getInstance().getProperty("user_authenticated")) != null;

        if (loggedIn) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
        config = null;
    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }
}
