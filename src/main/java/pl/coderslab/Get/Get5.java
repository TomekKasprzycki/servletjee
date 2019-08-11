package pl.coderslab.Get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

@WebServlet("/get5")
public class Get5 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        PrintWriter writer=response.getWriter();

        writer.append("<html><body>");
        writer.append("<ul>");

        Set<String> keys=  parameterMap.keySet();

        for (String key:keys){
            writer.append("<li>");
            writer.append(key);
            String[] values = parameterMap.get(key);

            writer.append("<ol>");
            for (String value:values){
                writer.append("<li>"+value+"</li>");
            }
            writer.append("</ol>");

            writer.append("</li>");
        }


        writer.append("</ul>");
        writer.append("</body></html>");
        response.setContentType("text/html");
    }
}
