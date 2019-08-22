package pl.coderslab.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin/*")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Cookie[] cookies = ((HttpServletRequest) req).getCookies();

        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                } else {
                HttpServletResponse httpResponse = (HttpServletResponse) resp;
                httpResponse.sendRedirect("/servletjee/login.jsp");
            }
        }

        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
