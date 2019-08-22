package pl.coderslab.DAO;

import java.sql.*;
import java.util.List;

public class userDAO {
    private static final String URL =
            "jdbc:mysql://localhost:3306/websitelogs?useSSL=false&characterEncoding=utf8&serverTimezone=CET&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "coderslab";
    private String qrySelectUser = "SELECT username, userpassword FROM users WHERE userlogin=?";

    public int veryficatePassord (String login, String password){
        int result = 0;

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)){

            PreparedStatement preparedStatement=connection.prepareStatement(qrySelectUser, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,login);

            preparedStatement.executeUpdate();

            ResultSet userData = preparedStatement.executeQuery();

            ResultSet rs=preparedStatement.getGeneratedKeys();

            if (rs.next()){
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
