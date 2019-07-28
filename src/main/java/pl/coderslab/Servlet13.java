package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/servlet13")
public class Servlet13 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().append("<p>Todey is: " + LocalDate.now().toString() + "</p>");
        response.getWriter().append("<p>Request send from IP: " + request.getRemoteAddr() + "</p>");
        response.getWriter().append("<p>Browser: " + request.getHeader("user-agent")+"</p>");

    }
}
