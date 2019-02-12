package com.ss.touragency.util;

import com.ss.touragency.dao.*;
import com.ss.touragency.service.CountryService;
import com.ss.touragency.service.HotelService;
import com.ss.touragency.service.OrderDetailsService;

public class Context {

    private static volatile Context instance;

    CountryDao countryDao;
    CityDao cityDao;
    HotelDao hotelDao;
    ClientDao clientDao;
    VisaDao visaDao;
    OrderDetailsDao orderDetailsDao;

    CountryService countryService;
    HotelService hotelService;
    OrderDetailsService orderDetailsService;

    public CountryService getCountryService() {
        return countryService;
    }

    public HotelService getHotelService() {
        return hotelService;
    }

    public OrderDetailsService getOrderDetailsService() {
        return orderDetailsService;
    }

    private Context() {
        initComponents();
    }

    private void initComponents() {
        countryDao = new CountryDao();
        cityDao = new CityDao();
        hotelDao = new HotelDao();
        clientDao = new ClientDao();
        visaDao = new VisaDao();
        orderDetailsDao = new OrderDetailsDao();

        countryService = new CountryService();
        hotelService = new HotelService();
        orderDetailsService = new OrderDetailsService();
    }

    public static Context getInstance() {
        if (instance == null) {
            synchronized (Context.class) {
                if (instance == null) {
                    instance = new Context();
                }
            }
        }
        return instance;
    }
}
