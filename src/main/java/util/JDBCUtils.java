package util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author wunu
 * @create 2020-05-15 15:36
 * 描述:
 */
public class JDBCUtils {

    private static String url = "jdbc:mysql://localhost:3306/finalproject?serverTimezone=UTC";
    private static String user = "root";
    private static String password = "wunu";
    private static String driver ="com.mysql.cj.jdbc.Driver";
    /**
     * 文件的读取
     * 静态代码块
     * @return
     */
    public static Connection getConnection() throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url,user,password);
    }

    public static void close(PreparedStatement pst,Connection conn){
       close(null,pst,conn);
    }

    public static void close(ResultSet res,PreparedStatement pst, Connection conn){
        if (pst != null){
            try {
                pst.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (res != null){
            try {
                res.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
