package pl.coderslab.Get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get1")
public class Get1 extends HttpServlet {

    final static int HTTP_BAD_REQUEST = 400;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");


        try {
            int intStart = Integer.parseInt(start);
            int intEnd = Integer.parseInt(end);

            PrintWriter writer = response.getWriter();

            writer.append("<html><body>");
            writer.append("<ul>");
            for (int i=intStart;i<=intEnd;i++){
                writer.append("<li>"+i+"</li>");
            }
            writer.append("</ul></body></html>");
            response.setContentType("text/html");


        } catch (NumberFormatException e){
            response.sendError(HTTP_BAD_REQUEST,"Błędny parametr. Musi być liczba całkowita!");

        }





    }
}
