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
            for (Cookie cookie : cookies) {
                writer.append(cookie.getName() + ", " + cookie.getValue() + "; "); //+ button do usunięcia
            }
        } else {
            writer.append("Nie ma ciasteczek!");
        }
    }
}
