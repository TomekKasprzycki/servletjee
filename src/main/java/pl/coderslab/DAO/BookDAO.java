package pl.coderslab.DAO;

import pl.coderslab.Model.Book;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class BookDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/book?useSSL=false&characterEncoding=utf8&serverTimezone=CET&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "coderslab";
    private static BookDAO instance;
    private Connection connection;

    private static String qryAddBook = "INSERT INTO books (author, title, isbn) VALUES (?,?,?)";

    private BookDAO() throws SQLException, ClassNotFoundException {
        String className = "com.mysql.cj.jdbc.Driver";
        Class.forName(className);
        BookDAO.instance = this;
        connection = DriverManager.getConnection(BookDAO.URL, BookDAO.USER, BookDAO.PASSWORD);
    }

    public void reconnect() throws SQLException {
        if (connection != null && connection.isClosed()) {
            connection = DriverManager.getConnection(BookDAO.URL, BookDAO.USER, BookDAO.PASSWORD);
        }
    }

    public static BookDAO getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new BookDAO();
        }
        return instance;
    }

    public int addBook(Book book) throws SQLException {


            PreparedStatement preparedStatement=connection.prepareStatement(qryAddBook, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,book.getAuthor());
            preparedStatement.setString(2,book.getTitle());
            preparedStatement.setString(3,book.getIsbn());

            preparedStatement.executeUpdate();


            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        return 0;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public List<Book> getAllBooks () throws SQLException {
        String query = "SELECT * FROM books";
         PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Book> result=new ArrayList<>();


        while (rs.next()) {

            result.add( new Book(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4)));

        }

        return result;
    }

    public void edit(int id) throws SQLException{
        //in progress
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
