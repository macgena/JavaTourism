package com.anna.commands;

import com.anna.menu.MenuType;
import com.anna.tourism.TourismType;
import com.anna.transport.TransportType;

import java.util.Date;

public class FilterCommand extends BaseCommand {
    private Date startDate;
    private Date endDate;
    private MenuType menuType;
    private TransportType transportType;
    private TourismType tourismType;
    private String country;

    public FilterCommand(Date startDate, Date endDate, MenuType menuType, TransportType transportType, TourismType tourismType, String country) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.menuType = menuType;
        this.transportType = transportType;
        this.tourismType = tourismType;
        this.country = country;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public TourismType getTourismType() {
        return tourismType;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public CommandType getType() {
        return CommandType.FILTER;
    }
}
