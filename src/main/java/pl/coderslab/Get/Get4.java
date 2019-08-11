package pl.coderslab.Get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get4")
public class Get4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberStr = request.getParameter("page");

        try{
            int number = Integer.parseInt(numberStr);
            String mod="";
            for (int i=1;i<=number;i++) {
                if (number % i == 0) {
                    if (mod.equals("")) {
                        mod = "" + i;
                    } else {
                        mod = mod + ", " + i;
                    }
                }
            }

            PrintWriter printWriter = response.getWriter();
            printWriter.append("<html><body>");
            printWriter.append("Dzielniki liczby: " + number + " to: " + mod);
            printWriter.append("</body></html>");
            response.setContentType("text/html");


        }catch (NumberFormatException e){}

    }
}
