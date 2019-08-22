package pl.coderslab.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/showAllCookies")
public class Cookie4Show extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        PrintWriter writer = response.getWriter();

        if (cookies!=null) {
            writer.append("<html><body>");
            for (Cookie cookie : cookies) {
                writer.append("<p>" + cookie.getName() + ", " + cookie.getValue() + "</p>"); //+ button do usunięcia
            }
            writer.append("</body></html>");
            response.setContentType("text/html");
        } else {
            writer.append("Nie ma ciasteczek!");
        }
    }
}
