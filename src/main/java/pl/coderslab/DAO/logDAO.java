package pl.coderslab.DAO;

import pl.coderslab.Model.Log;

import java.sql.*;

public class logDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/websitelogs?useSSL=false&characterEncoding=utf8&serverTimezone=CET&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "coderslab";
    private static logDAO instance;
    private Connection connection;
    private String qryAddData = "INSERT INTO webLogs (logStartDate, logEndDate, userAgent, userName) VALUES (?,?,?,?)";

    private logDAO() throws SQLException, ClassNotFoundException {
        String className = "com.mysql.cj.jdbc.Driver";
        Class.forName(className); // THIS IS THE SHIT
        // ​
        logDAO.instance = this;
        connection = DriverManager.getConnection(logDAO.URL, logDAO.USER, logDAO.PASSWORD);
    }

    public logDAO getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new logDAO();
        }
        return instance;
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

    public boolean writeApplicationLogs(Log log)throws SQLException {
        boolean result = false;

        PreparedStatement preparedStatement = connection.prepareStatement(qryAddData, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,log.getUserAgent());
        preparedStatement.setString(2,log.getUserName());
        preparedStatement.setLong(3,log.getLogStartDate());
        preparedStatement.setLong(4,log.getLogEndDate());

        preparedStatement.executeUpdate();

        ResultSet rs = preparedStatement.getGeneratedKeys();

        if(rs.next()) {
            result = true;
        }

        return result;
    }

}
