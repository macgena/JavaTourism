package com.anna;

import com.anna.commands.*;
import com.anna.menu.MenuType;
import com.anna.tourism.TourismType;
import com.anna.transport.TransportType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ApplicationMenu {
    private Scanner scanner;

    public ApplicationMenu() {
        this.scanner = new Scanner(System.in);
    }

    public BaseCommand readCommand() {
        BaseCommand result = new ExitCommand();
        System.out.println("Choose action: ");
        System.out.println("1. Print all vouchers");
        System.out.println("2. Sort by parameters");
        System.out.println("3. Filter by parameters");
        System.out.println("4. Exit");
        if(scanner.hasNextInt()) {
            int action = scanner.nextInt();
            switch(action) {
                case 1: {
                    result = new ShowAllCommand();
                    break;
                }
                case 2: {
                    result = buildSortByCommand();
                    break;
                }
                case 3: {
                    result = buildFilterCommand();
                    break;
                }
                default:
                    result = new ExitCommand();
            }
        }
        return result;
    }

    private FilterCommand buildFilterCommand() {
        MenuType menuType = null;
        TransportType transportType = null;
        TourismType tourismType = null;
        Date startDate, endDate;
        String country = null;
        int action;

        System.out.println("Set parameters for filtering: ");

        System.out.println("Enter country you wanna visit: ");
        System.out.println("0. Skip selection");
        System.out.println("1. Enter country");

        if (scanner.hasNextInt()) {
            action = scanner.nextInt();
            if (action == 1) {
                if (scanner.hasNext()) {
                    country = scanner.next();
                }
            }
        }

        System.out.println("Choose menu type: ");
        System.out.println("0. Skip selection");
        System.out.println("1. All included");
        System.out.println("2. Breakfast included");
        if (scanner.hasNextInt()) {
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    menuType =  MenuType.ALL_INCLUDED;
                    break;
                case 2:
                    menuType = MenuType.BREAKFAST_INCLUDED;
                    break;
                default:
                    menuType = null;
            }
        }

        System.out.println("Choose transport type: ");
        System.out.println("0. Skip selection");
        System.out.println("1. Bus");
        System.out.println("2. Car");
        System.out.println("3. Plane");
        System.out.println("4. Train");

        if (scanner.hasNextInt()) {
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    transportType = TransportType.BUS;
                    break;
                case 2:
                    transportType = TransportType.CAR;
                    break;
                case 3:
                    transportType = TransportType.PLANE;
                    break;
                case 4:
                    transportType = TransportType.TRAIN;
                    break;
                default:
                    transportType = null;
            }
        }

        System.out.println("Enter type of your travel: ");
        System.out.println("0. Skip selection");
        System.out.println("1. Cruise");
        System.out.println("2. Excursion");
        System.out.println("3. Shopping");
        System.out.println("4. Treatment");

        if (scanner.hasNextInt()) {
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    tourismType = TourismType.CRUISE;
                    break;
                case 2:
                    tourismType = TourismType.EXCURSION;
                    break;
                case 3:
                    tourismType = TourismType.SHOPPING;
                    break;
                case 4:
                    tourismType = TourismType.TREATMENT;
                    break;
                default:
                    tourismType = null;
            }
        }

        startDate = readDate("Start Date");
        endDate = readDate("End Date");

        return new FilterCommand(startDate, endDate, menuType, transportType, tourismType, country);
    }

    private Date readDate(String variableName) {
        Date result = null;
        boolean parsed = false;
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        int action;

        while (!parsed) {
            System.out.println("Enter your" + variableName + " in format dd/mm/yyyy");
            System.out.println("0. Skip selection");
            System.out.println("1. Enter date");

            if (scanner.hasNextInt()) {
                action = scanner.nextInt();
                if (action == 0) {
                    break;
                }
            }

            if (scanner.hasNext()) {
                String dateString = scanner.next();
                try {
                    result = dateFormatter.parse(dateString);
                    parsed = true;
                } catch (ParseException e) {
                    System.out.println("You entered invalid date");
                }
            }
        }

        return result;
    }

    private SortCommand buildSortByCommand() {
        String sortBy = null;
        String sortOrder = null;
        int action;

        System.out.println("Choose parameter for sorting: ");
        System.out.println("1. Start date");
        System.out.println("2. End date");
        if (scanner.hasNextInt()) {
           action = scanner.nextInt();
           sortBy = action == 1 ? "startDate" : "endDate";
        }

        System.out.println("Choose sort order: ");
        System.out.println("1. ASC");
        System.out.println("2. DESC");
        if (scanner.hasNextInt()) {
            action = scanner.nextInt();
            sortOrder = action == 1 ? "ASC" : "DESC";
        }

        return new SortCommand(sortBy, sortOrder);
    }
}
