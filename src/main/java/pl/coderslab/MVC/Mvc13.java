package pl.coderslab.MVC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import pl.coderslab.Model.Book;
import pl.coderslab.DAO.BookDAO;

@WebServlet("/mvc13")
public class Mvc13 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");

        Book book = new Book(author,title,isbn);
//        BookDAO.addBook(author,title,isbn);

        request.setAttribute("book",book);
        getServletContext().getRequestDispatcher("/mvc/result.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/mvc/jsp3.jsp").forward(request,response);
    }
}
