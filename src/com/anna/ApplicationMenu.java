package com.anna;

import com.anna.commands.*;
import com.anna.exceptions.InvalidCountryException;
import com.anna.exceptions.InvalidIntCommandException;
import com.anna.menu.MenuType;
import com.anna.tourism.TourismType;
import com.anna.transport.TransportType;
import com.anna.validators.CountryValidator;

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
        BaseCommand result;
        int action;
        System.out.println("Choose action: ");
        action = readIntCommand(new String[] { "Exit", "Print all vouchers", "Sort by parameters", "Filter by parameters" });
        switch (action) {
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
        action = readIntCommand(new String[]{"Skip selection", "Enter country"});

        if (action == 1) {
            country = readCountry();
        }

        System.out.println("Choose menu type: ");
        action = readIntCommand(new String[]{"Skip selection", "All included", "Breakfast included"});
        switch (action) {
            case 1:
                menuType = MenuType.ALL_INCLUDED;
                break;
            case 2:
                menuType = MenuType.BREAKFAST_INCLUDED;
                break;
            default:
                menuType = null;
        }

        System.out.println("Choose transport type: ");
        action = readIntCommand(new String[]{"Skip selection", "Bus", "Car", "Plane", "Train"});
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

        System.out.println("Enter type of your travel: ");
        action = readIntCommand(new String[]{"Skip selection", "Cruise", "Excursion", "Shopping", "Treatment"});
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

        startDate = readDate("Start Date");
        endDate = readDate("End Date");

        return new FilterCommand(startDate, endDate, menuType, transportType, tourismType, country);
    }

    private Date readDate(String variableName) {
        Date result = null;
        boolean parsed = false;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        int action;

        while (!parsed) {
            System.out.println("Enter your" + variableName + " in format dd/mm/yyyy");
            action = readIntCommand(new String[]{"Skip selection", "Enter date"});

            if (action == 0) {
                break;
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

    private int readIntCommand(String[] commands) {
        boolean parsed = false;
        int result = -1;

        while (!parsed) {
            for (int i = 0; i < commands.length; i++) {
                System.out.println(i + ". " + commands[i]);
            }
            try {
                if (scanner.hasNextInt()) {
                    result = scanner.nextInt();

                    if (result > commands.length - 1 || result < 0) {
                        throw new InvalidIntCommandException("You should enter a number between 0 and " + (commands.length - 1));
                    } else {
                        parsed = true;
                    }
                } else {
                    scanner.next();
                    throw new InvalidIntCommandException("You should enter a number between 0 and " + (commands.length - 1));
                }
            } catch (InvalidIntCommandException e) {
                System.out.println(e.getMessage());
            }
        }

        return result;
    }

    private String readCountry() {
        boolean parsed = false;
        String country = null;

        while (!parsed) {
            System.out.println("Write your country: ");
            if (scanner.hasNext()) {
                try {
                    country = CountryValidator.validateCountry(scanner.next());
                    parsed = true;
                } catch (InvalidCountryException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return country;
    }

    private SortCommand buildSortByCommand() {
        String sortBy = null;
        String sortOrder = null;
        int action;

        System.out.println("Choose parameter for sorting: ");
        action = readIntCommand(new String[]{"Start date", "End date"});
        sortBy = action == 1 ? "startDate" : "endDate";

        System.out.println("Choose sort order: ");
        action = readIntCommand(new String[]{"Start date", "End date"});
        sortOrder = action == 1 ? "ASC" : "DESC";

        return new SortCommand(sortBy, sortOrder);
    }
}
