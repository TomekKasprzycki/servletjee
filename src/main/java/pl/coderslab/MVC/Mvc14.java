package pl.coderslab.MVC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import pl.coderslab.Model.Book;

@WebServlet("/mvc14")
public class Mvc14 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] author = request.getParameterValues("author");
        String[] title = request.getParameterValues("title");
        String[] isbn = request.getParameterValues("isbn");

        Book[] books = new Book[5];

        for (int i=0; i<author.length;i++){
            books[i] = new Book(author[i],title[i],isbn[i]);
        }


        request.setAttribute("books",books);
        getServletContext().getRequestDispatcher("/mvc/result2.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/mvc/jsp4.jsp").forward(request,response);
    }
}
