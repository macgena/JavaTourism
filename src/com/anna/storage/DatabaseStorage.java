package com.anna.storage;

import com.anna.Voucher;
import com.mysql.cj.jdbc.Driver;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseStorage extends BaseStorage {
    private static final String DATABASE_URL = "jdbc:mysql://localhost/java_tourism";

    @Override
    public ArrayList<Voucher> readAll() {
        try(Connection connection = DriverManager.getConnection(DATABASE_URL, "tourism", "password")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM vouchers " +
                    "INNER JOIN transports ON transports.id = vouchers.transport_id " +
                    "INNER JOIN tourism ON tourism.id = vouchers.tourism_id " +
                    "INNER JOIN menu ON menu.id = vouchers.menu_id");
            while(resultSet.next()) {
                //
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
