package pl.coderslab.MVC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import pl.coderslab.Model.Book;
import pl.coderslab.DAO.BookDAO;

@WebServlet("/mvc13")
public class Mvc13 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");

        Book book = new Book(author, title, isbn);

        try {
            BookDAO bookDAO = BookDAO.getInstance();
            bookDAO.addBook(book);
            request.setAttribute("book", book);
            getServletContext().getRequestDispatcher("/mvc/result.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/mvc/jsp3.jsp").forward(request,response);
    }
}
