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
import java.util.List;

@WebServlet("/allBooks")
public class mvcjdbc03 extends HttpServlet {
    private int HTTP_ERROR = 500;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Book> books = BookDAO.getInstance().getAllBooks();
            request.setAttribute("books",books);
        }catch (SQLException|ClassNotFoundException e){
            response.sendError(HTTP_ERROR,e.getMessage());
        }

        getServletContext().getRequestDispatcher("/jdbc2.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Book> books = BookDAO.getInstance().getAllBooks();
            request.setAttribute("books",books);
        }catch (SQLException|ClassNotFoundException e){
            response.sendError(HTTP_ERROR,e.getMessage());
        }

        getServletContext().getRequestDispatcher("/jdbc/jdbc2.jsp").forward(request,response);
    }
}
