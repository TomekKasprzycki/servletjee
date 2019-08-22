package pl.coderslab.DAO;

import pl.coderslab.Model.Log;

import java.sql.*;

public class LogDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/websitelogs?useSSL=false&characterEncoding=utf8&serverTimezone=CET&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "coderslab";
    private static LogDAO instance;
    private Connection connection;
    private String qryAddData = "INSERT INTO webLogs (logStartDate, logEndDate, userAgent, userName) VALUES (?,?,?,?)";

    private LogDAO() throws SQLException, ClassNotFoundException {
        String className = "com.mysql.cj.jdbc.Driver";
        Class.forName(className);
        LogDAO.instance = this;
        connection = DriverManager.getConnection(LogDAO.URL, LogDAO.USER, LogDAO.PASSWORD);
    }

    public static LogDAO getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new LogDAO();
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
