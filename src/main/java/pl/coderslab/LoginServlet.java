package pl.coderslab;

import pl.coderslab.DAO.userDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        if (!session.getAttribute("username").equals(login)) {

            int i = userDAO.veryficatePassord(login, password);

            if (i == 2) {

                session.setAttribute("username", login);
            }
        }
    }


}
