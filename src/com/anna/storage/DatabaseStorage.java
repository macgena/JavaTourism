package com.anna.storage;

import com.anna.Voucher;
import com.anna.menu.*;
import com.anna.tourism.*;
import com.anna.transport.*;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseStorage extends BaseStorage {
    private static final String DATABASE_URL = "jdbc:mysql://localhost/java_tourism";

    @Override
    public ArrayList<Voucher> readAll() {
        ArrayList<Voucher> result = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(DATABASE_URL, "tourism", "password")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM vouchers " +
                    "INNER JOIN transports ON transports.id = vouchers.transport_id " +
                    "INNER JOIN tourism ON tourism.id = vouchers.tourism_id " +
                    "INNER JOIN menu ON menu.id = vouchers.menu_id");
            while(resultSet.next()) {
                result.add(buildVoucher(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Voucher buildVoucher(ResultSet resultSet) {
        Voucher voucher = new Voucher();
        try {
            voucher.setCountry(resultSet.getString("country"));
            voucher.setStartDate(resultSet.getDate("start_date"));
            voucher.setEndDate(resultSet.getDate("end_date"));
            voucher.setMenu(buildMenu(resultSet));
            voucher.setTourism(buildTourism(resultSet));
            voucher.setTransport(buildTransport(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voucher;
    }

    private BaseMenu buildMenu(ResultSet resultSet) throws SQLException {
        switch (resultSet.getString("menu.type")) {
            case "ALL_INCLUDED":
                return new AllIncludedMenu(resultSet.getDouble("menu.calories"));
            case "BREAKFAST_INCLUDED":
                return new BreakfastMenu(resultSet.getDouble("menu.calories"));
            default:
                return null;
        }
    }

    private BaseTransport buildTransport(ResultSet resultSet) throws SQLException {
        switch (resultSet.getString("transports.type")) {
            case "CAR":
                return new Car();
            case "TRAIN":
                return new Train();
            case "BUS":
                return new Bus();
            case "PLANE":
                return new Plane();
            default:
                return null;
        }
    }

    private BaseTourism buildTourism(ResultSet resultSet) throws SQLException {
        switch (resultSet.getString("tourism.type")) {
            case "CRUISE":
                return new Cruise();
            case "EXCURSION":
                return new Excursion();
            case "SHOPPING":
                return new Shopping();
            case "TREATMENT":
                return new Treatment();
            default:
                return null;
        }
    }
}
