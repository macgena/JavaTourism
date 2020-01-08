package com.anna;

import com.anna.menu.BaseMenu;
import com.anna.tourism.BaseTourism;
import com.anna.transport.BaseTransport;

import java.io.Serializable;
import java.util.Date;

public class Voucher implements Serializable {
    private Date startDate;
    private Date endDate;
    private BaseMenu menu;
    private BaseTourism tourism;
    private BaseTransport transport;
    private String country;

    public Voucher() {
    };

    public Voucher(Date startDate, Date endDate, BaseMenu menu, BaseTourism tourism, BaseTransport transport, String country) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.menu = menu;
        this.tourism = tourism;
        this.transport = transport;
        this.country = country;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BaseMenu getMenu() {
        return menu;
    }

    public void setMenu(BaseMenu menu) {
        this.menu = menu;
    }

    public BaseTourism getTourism() {
        return tourism;
    }

    public void setTourism(BaseTourism tourism) {
        this.tourism = tourism;
    }

    public BaseTransport getTransport() {
        return transport;
    }

    public void setTransport(BaseTransport transport) {
        this.transport = transport;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Country: " + country + "\n" + "Start Date: " + startDate + "\n" + "End Date: " + endDate + "\n" +
                "Menu: " + menu + "\n" + "Tourism: " + tourism + "\n" + "Transport: " + transport + "\n";
    }
}
