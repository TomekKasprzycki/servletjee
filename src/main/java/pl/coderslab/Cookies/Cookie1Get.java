package pl.coderslab.Cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/showCookie")
public class Cookie1Get extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();

        PrintWriter writer = response.getWriter();

        if (cookies!=null) {
            String cookieUser = CookieUtil.retriveCookie(cookies, "user");

            if (cookieUser.isEmpty()) {
                writer.append("Brak ciasteczka o nazwie user");
            } else {
                writer.append("Znaleziono ciasteczko user: " + cookieUser);
            }
        } else {
            writer.append("Brak ciasteczek!");
        }

    }


}
