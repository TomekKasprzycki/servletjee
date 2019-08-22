package pl.coderslab.DAO;

import java.sql.*;

public class UserDAO {
    private static final String URL =
            "jdbc:mysql://localhost:3306/websitelogs?useSSL=false&characterEncoding=utf8&serverTimezone=CET&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "coderslab";
    private static UserDAO instance;
    private Connection connection;
    private String qrySelectUser = "SELECT username, userpassword FROM users WHERE username=?";

    private UserDAO() throws  SQLException, ClassNotFoundException {
        String className = "com.mysql.cj.jdbc.Driver";
        Class.forName(className);
        UserDAO.instance = this;
        connection = DriverManager.getConnection(UserDAO.URL, UserDAO.USER, UserDAO.PASSWORD);
    }

    public static UserDAO getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public int veryficatePassord (String login, String password){
        int result = 0;

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)){

            PreparedStatement preparedStatement=connection.prepareStatement(qrySelectUser, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,login);


            ResultSet userData = preparedStatement.executeQuery();


            if (userData.next()){
                result = 1;
                if (userData.getString(2).equals(password)) {
                    result = 2;
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }



}
