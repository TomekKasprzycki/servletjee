package pl.coderslab.jdbc;

import pl.coderslab.DAO.BookDAO;
import pl.coderslab.Model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addBook")
public class mvcjdbc01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");

        Book book = new Book(author,title,isbn);
        try {
            BookDAO.getInstance().addBook(book);
        } catch (ClassNotFoundException|SQLException e){
            response.sendError(500,e.getMessage());
        }
        request.setAttribute("book",book);
        getServletContext().getRequestDispatcher("/mvc/result.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jdbc/jdbc1.jsp").forward(request,response);
    }
}
