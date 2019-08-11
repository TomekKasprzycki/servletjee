package pl.coderslab.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteCookie")
public class Cookie1Delete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        PrintWriter writer=response.getWriter();
        String cookieUser = CookieUtil.retriveCookie(cookies,"user");

        if(cookieUser.isEmpty()){
            writer.append("Brak ciasteczka o nazwie user.");
        } else {
            CookieUtil.deleteCookie(cookies,"user", response);
        }


    }
}
