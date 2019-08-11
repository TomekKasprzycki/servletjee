package pl.coderslab.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie3")
public class Cookie3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cookieName = request.getParameter("key");
        String cookieValue = request.getParameter("value");
        String cookieTime = request.getParameter("time");
        int cookieTimeInt = Integer.parseInt(cookieTime)*60*60;

        Cookie cookie = new Cookie(cookieName,cookieValue);
        cookie.setMaxAge(cookieTimeInt);
        response.addCookie(cookie);


    }


}
