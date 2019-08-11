package pl.coderslab.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/post3")
public class Post3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aValueStr = request.getParameter("aValue");
        String bValueStr = request.getParameter("bValue");
        String cValueStr = request.getParameter("cValue");

//        bla, bla, bla

        PrintWriter writer = response.getWriter();
        writer.append(String.format("Dla funkcji %sx2+%sx+%s sa dla x=", aValueStr,bValueStr,cValueStr));


    }

}
