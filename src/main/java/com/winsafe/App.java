package com.winsafe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.err.println("第" + i + "次查询.............");
            execute();
        }
    }

    public static void execute() {
        long l = System.currentTimeMillis();
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("select [2DCode] as wdcode, * from ProRecord WHERE (1=1 and lotno= ? and lasercode like ? ) ");
            prepareStatement.setString(1, "E1");
            prepareStatement.setString(2, "1960003750%");
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                System.err.println(resultSet.getString("wdcode"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.err.println("花费时间" + (System.currentTimeMillis() - l) / 1000);
    }


}
