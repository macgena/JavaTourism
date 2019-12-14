package com.anna;

import com.anna.menu.AllIncludedMenu;
import com.anna.menu.BreakfastMenu;
import com.anna.tourism.Shopping;
import com.anna.tourism.Treatment;
import com.anna.transport.Bus;
import com.anna.transport.Car;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VoucherFactory {
    public static List<Voucher> loadVouchers() throws Exception {
        Voucher voucher1 = new Voucher(
                new SimpleDateFormat("dd/MM/yyyy").parse("20/09/2019"),
                new SimpleDateFormat("dd/MM/yyyy").parse("30/09/2019"),
                new AllIncludedMenu(1700.0),
                new Treatment(),
                new Car()
        );
        Voucher voucher2 = new Voucher(
                new SimpleDateFormat("dd/MM/yyyy").parse("10/02/2019"),
                new SimpleDateFormat("dd/MM/yyyy").parse("24/02/2019"),
                new BreakfastMenu(500.0),
                new Shopping(),
                new Bus()
        );

        Voucher voucher3 = new Voucher(
                new SimpleDateFormat("dd/MM/yyyy").parse("11/12/2019"),
                new SimpleDateFormat("dd/MM/yyyy").parse("19/12/2019"),
                new AllIncludedMenu(1700.0),
                new Treatment(),
                new Car()
        );

        Voucher voucher4 = new Voucher(
                new SimpleDateFormat("dd/MM/yyyy").parse("13/03/2020"),
                new SimpleDateFormat("dd/MM/yyyy").parse("27/03/2020"),
                new BreakfastMenu(500.0),
                new Shopping(),
                new Bus()
        );

        Voucher voucher5 = new Voucher(
                new SimpleDateFormat("dd/MM/yyyy").parse("23/06/2019"),
                new SimpleDateFormat("dd/MM/yyyy").parse("31/06/2019"),
                new AllIncludedMenu(1700.0),
                new Treatment(),
                new Car()
        );

        Voucher voucher6 = new Voucher(
                new SimpleDateFormat("dd/MM/yyyy").parse("28/05/2019"),
                new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2019"),
                new BreakfastMenu(500.0),
                new Shopping(),
                new Bus()
        );

        List<Voucher> vouchers = new ArrayList<>();
        vouchers.add(voucher1);
        vouchers.add(voucher2);
        vouchers.add(voucher3);
        vouchers.add(voucher4);
        vouchers.add(voucher5);
        vouchers.add(voucher6);

        return vouchers;
    }
}
