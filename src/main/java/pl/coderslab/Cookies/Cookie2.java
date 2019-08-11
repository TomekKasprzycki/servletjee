package pl.coderslab.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie2")
public class Cookie2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cookieName = request.getParameter("key");
        String cookieValue = request.getParameter("value");

        Cookie cookie = new Cookie(cookieName,cookieValue);
        response.addCookie(cookie);

    }
}
