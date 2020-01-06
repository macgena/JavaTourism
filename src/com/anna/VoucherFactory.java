package com.anna;

import com.anna.menu.AllIncludedMenu;
import com.anna.menu.BreakfastMenu;
import com.anna.tourism.Shopping;
import com.anna.tourism.Treatment;
import com.anna.transport.Bus;
import com.anna.transport.Car;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VoucherFactory {
    public static ArrayList<Voucher> loadVouchers() {
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

        Voucher voucher1 = new Voucher(
                parseDate(dateFormatter, "20/09/2019"),
                parseDate(dateFormatter, "30/09/2019"),
                new AllIncludedMenu(1700.0),
                new Treatment(),
                new Car(),
                "Turkey"
        );
        Voucher voucher2 = new Voucher(
                parseDate(dateFormatter, "10/02/2019"),
                parseDate(dateFormatter, "24/02/2019"),
                new BreakfastMenu(500.0),
                new Shopping(),
                new Bus(),
                "Maldives"
        );

        Voucher voucher3 = new Voucher(
                parseDate(dateFormatter, "11/12/2019"),
                parseDate(dateFormatter, "19/12/2019"),
                new AllIncludedMenu(1700.0),
                new Treatment(),
                new Car(),
                "Japan"
        );

        Voucher voucher4 = new Voucher(
                parseDate(dateFormatter, "13/03/2020"),
                parseDate(dateFormatter, "27/03/2020"),
                new BreakfastMenu(500.0),
                new Shopping(),
                new Bus(),
                "South Korea"
        );

        Voucher voucher5 = new Voucher(
                parseDate(dateFormatter, "23/06/2019"),
                parseDate(dateFormatter, "31/06/2019"),
                new AllIncludedMenu(1700.0),
                new Treatment(),
                new Car(),
                "Belarus"
        );

        Voucher voucher6 = new Voucher(
                parseDate(dateFormatter, "28/05/2019"),
                parseDate(dateFormatter, "10/06/2019"),
                new BreakfastMenu(500.0),
                new Shopping(),
                new Bus(),
                "Poland"
        );

        ArrayList<Voucher> vouchers = new ArrayList<>();
        vouchers.add(voucher1);
        vouchers.add(voucher2);
        vouchers.add(voucher3);
        vouchers.add(voucher4);
        vouchers.add(voucher5);
        vouchers.add(voucher6);

        return vouchers;
    }

    private static Date parseDate(SimpleDateFormat dateFormatter, String dateString) {
        Date result = null;
        try {
            result = dateFormatter.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date passed");
            e.printStackTrace();
        }
        return result;
    }
}
