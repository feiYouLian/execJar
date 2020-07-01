package com.winsafe;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://10.87.210.5;DatabaseName=BASFLogisticDB";
    private static String user = "sa";
    private static String password = "Passw0rd";

    // 连接数据库的方法
    public static Connection getConnection() {
        try {
            // 初始化驱动包
            Class.forName(driver);
            // 根据数据库连接字符，名称，密码给conn赋值
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
