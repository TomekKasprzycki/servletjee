package pl.coderslab.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sessionGet")
public class SessionGet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();

        Object counter = session.getAttribute("counter");
        writer.append("Sesja o ID: "+session.getId() +"; ");
        writer.append("Czy nowa: "+session.isNew()+"; ");

        if (counter==null){
            writer.append("Empty");
        } else {
            int counterInt = (int) counter;
            writer.append("Counter=" + counterInt +"; ");
            counterInt++;
            session.setAttribute("counter",counterInt);
        }


    }
}
