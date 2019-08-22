package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    private int COOKIE_HOUR = 3600;
    private String userName = System.getProperty("user.name");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        response.getWriter().println("<h1>Welcome " + name + "</h1>");
        System.out.println("Przyszło żadanie od klienta!");

        Cookie cookie = new Cookie("user",userName);
        cookie.setMaxAge(COOKIE_HOUR);
        response.addCookie(cookie);

    }
}
