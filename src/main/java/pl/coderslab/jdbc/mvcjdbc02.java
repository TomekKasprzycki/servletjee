package pl.coderslab.jdbc;

import pl.coderslab.DAO.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteBook")
public class mvcjdbc02 extends HttpServlet {

    private final int HTTP_INTERAL_ERROR = 500;
    private final int HTTP_BAD_REQUEST = 400;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            int id = Integer.parseInt(request.getParameter("id"));
            BookDAO.getInstance().delete(id);
        }catch (NumberFormatException e){
            response.sendError(HTTP_BAD_REQUEST,"Nieprawidłowe id!");
        }catch (SQLException|ClassNotFoundException e){
            response.sendError(HTTP_INTERAL_ERROR,e.getMessage());
        }

    }
}
