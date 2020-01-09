package com.anna;

import com.anna.commands.BaseCommand;
import com.anna.commands.FilterCommand;
import com.anna.commands.SortCommand;
import com.anna.storage.DatabaseStorage;
import com.anna.storage.XmlStorage;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        VoucherStorage voucherStorage = new VoucherStorage();
        XmlStorage xmlStorage = new XmlStorage();
        DatabaseStorage databaseStorage = new DatabaseStorage();
        ArrayList<Voucher> vouchers = databaseStorage.readAll();
        boolean exit = false;
        ApplicationMenu applicationMenu = new ApplicationMenu();
        BaseCommand command;

        while(!exit) {
            command = applicationMenu.readCommand();
            switch (command.getType()) {
                case EXIT:
                    exit = true;

                    System.out.println("Good bye!");
                    break;
                case SHOW_ALL: {
                    for (Voucher voucher: vouchers) {
                        System.out.println(voucher);
                    }
                    break;
                }
                case FILTER: {
                    List<Voucher> filteredVouchers = filterVouchers(vouchers, (FilterCommand)command);
                    for (Voucher voucher: filteredVouchers) {
                        System.out.println(voucher);
                    }
                    break;
                }
                case SORT: {
                    List<Voucher> sortedVouchers = sortVouchers(vouchers, (SortCommand) command);
                    for (Voucher voucher: sortedVouchers) {
                        System.out.println(voucher);
                    }
                    break;
                }
            }
        }
    }

    private static List<Voucher> filterVouchers(List<Voucher> vouchers, FilterCommand filterCommand) {
        List<Voucher> filteredVouchers = vouchers.stream().filter((voucher) -> {
            boolean menuType = filterCommand.getMenuType() == null || filterCommand.getMenuType() == voucher.getMenu().getType();
            boolean transportType = filterCommand.getTransportType() == null || filterCommand.getTransportType() == voucher.getTransport().getType();
            boolean tourismType = filterCommand.getTourismType() == null || filterCommand.getTourismType() == voucher.getTourism().getType();
            boolean startDate = filterCommand.getStartDate() == null || filterCommand.getStartDate().after(voucher.getStartDate());
            boolean endDate = filterCommand.getEndDate() == null || filterCommand.getEndDate().before(voucher.getEndDate());
            boolean country = filterCommand.getCountry() == null || filterCommand.getCountry().equals(voucher.getCountry());

            return menuType && transportType && tourismType && startDate && endDate && country;
        }).collect(Collectors.toList());

        return filteredVouchers;
    };

    private static List<Voucher> sortVouchers(List<Voucher> vouchers, SortCommand sortCommand) {
        Comparator comparator = Comparator.comparing((sortCommand.getSortBy().equals("startDate")) ? Voucher::getStartDate : Voucher::getEndDate);
        if (sortCommand.getSortOrder().equals("DESC")) {
            comparator = comparator.reversed();
        }
        return (List<Voucher>) vouchers.stream().sorted(comparator).collect(Collectors.toList());
    };
}
