package com.anna;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Voucher> vouchers = VoucherFactory.loadVouchers();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while(!exit) {
            System.out.println("Choose an action!");
            System.out.println("1. Print All");
            System.out.println("2. Sort by start date");
            System.out.println("3. Exit");

            if(scanner.hasNext()) {
                String input = scanner.next();

                switch (input) {
                    case "1": {
                        for(Voucher voucher: vouchers) {
                            System.out.println(voucher);
                        }
                        break;
                    }
                    case "2": {
                        List<Voucher> sortedVouchers = vouchers.stream()
                                .sorted(Comparator.comparing(Voucher::getStartDate))
                                .collect(Collectors.toList());
                        for(Voucher voucher: sortedVouchers) {
                            System.out.println(voucher);
                        }
                        break;
                    }
                    case "3": {
                        exit = true;
                        System.out.println("Good bye!");
                        break;
                    }
                    default:
                        System.out.println("Invalid operation");
                }
            }
        }
    }
}
