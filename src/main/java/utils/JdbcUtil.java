package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author fuyaling
 * @create 2021-09-27-{TIME}
 * <p>
 * 对jdbc操作进行封装
 */
public class JdbcUtil {

    public static final String url = "jdbc:mysql://120.77.38.41:3306/rental_db?useSSL=false";
    public static final String driver = "com.mysql.cj.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "root";


    private String sql;
    private Statement statement;


    public JdbcUtil(String sql) {
        this.sql = sql;
    }

    static {
        try{
            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //2、获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    //3、释放资源
    public void close(Connection connection,Statement statement,ResultSet resultSet){

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
