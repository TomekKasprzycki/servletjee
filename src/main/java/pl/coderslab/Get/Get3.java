package pl.coderslab.Get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;

@WebServlet("/get3")
public class Get3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String widthStr = request.getParameter("width");
        String heightStr = request.getParameter("height");


        int width=5;
        int height=10;


        try{
            height=Integer.parseInt(heightStr);
        }catch (NumberFormatException e){

        }
        try {
            width = Integer.parseInt(widthStr);
        }catch (NumberFormatException e){

        }
        PrintWriter printWriter = response.getWriter();

        printWriter.append("<html><body>");
        printWriter.append("<table>");
        for (int i=1;i<=width;i++) {
            printWriter.append("<tr>");
            for (int j = 1; j <= height; j++) {
                printWriter.append("<td>"+i*j+"</td>");
            }
        }

        printWriter.append("</tr>");
        printWriter.append("</table>");

        printWriter.append("</body></html>");

    }
}
