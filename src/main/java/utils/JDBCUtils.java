package utils;

import java.sql.*;

/**
 * 工具类 提供数据库连接池 和数据库连接
 */
public class JDBCUtils {
    public static final String url = "jdbc:mysql://120.77.38.41:3306/rental_db?useSSL=false";
    public static final String name = "com.mysql.cj.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "root";

    public Connection conn = null;
    public Statement statement = null;

    static {
        try{
            Class.forName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public JDBCUtils() {
        try {
            //1.getConnection()方法，连接MySQL数据库！！
            conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            statement = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
