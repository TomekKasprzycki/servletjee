package pl.coderslab.MVC;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc12")
public class Mvc12 extends HttpServlet {

    private static final int HTTP_BAD_REQUEST = 400;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startStr = request.getParameter("start");
        String endStr = request.getParameter("end");

        try {
            int start = Integer.parseInt(startStr);
            int end= Integer.parseInt(endStr);
            start+=10;
            end+=10;

            request.setAttribute("start",start);
            request.setAttribute("end",end);

            getServletContext().getRequestDispatcher("/mvc/jsp2.jsp").forward(request,response);

        }catch (NumberFormatException e){
            response.sendError(HTTP_BAD_REQUEST,"Podano błędny paramentr!");
        }


    }
}
