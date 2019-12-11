package com.anna;

import com.anna.menu.*;
import com.anna.tourism.*;
import com.anna.transport.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Voucher voucher1 = new Voucher(
                new SimpleDateFormat("dd/MM/yyyy").parse("20/09/2019"),
                new SimpleDateFormat("dd/MM/yyyy").parse("30/09/2019"),
                new AllIncludedMenu(),
                new Treatment(),
                new Car()
        );

        Voucher voucher2 = new Voucher(
                new SimpleDateFormat("dd/MM/yyyy").parse("10/02/2019"),
                new SimpleDateFormat("dd/MM/yyyy").parse("24/02/2019"),
                new BreakfastMenu(),
                new Shopping(),
                new Bus()
        );

        List<Voucher> vouchers = new ArrayList<Voucher>();
        vouchers.add(voucher1);
        vouchers.add(voucher2);

        for (Voucher voucher:vouchers) {
            System.out.println(voucher);
        }
    }
}
