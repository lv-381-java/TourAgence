package com.ss.touragency.service;

import com.ss.touragency.constants.Attribute;
import com.ss.touragency.dao.HotelDao;
import com.ss.touragency.entity.City;
import com.ss.touragency.entity.Hotel;

import javax.servlet.http.HttpServletRequest;

public class HotelService {


    // TODO: find out if City needed. assigned to Arsen
    public boolean getHotel(HttpServletRequest request) {
        boolean result = false;

        String hotelName = request.getParameter(Attribute.HOTEL_NAME);
        int availableCount = Integer.parseInt((String) request.getParameter(Attribute.AVAILABLE_COUNT));
        City city = new City();

        if (hotelName != null && !hotelName.isEmpty()) {
            HotelDao hotelDao = new HotelDao();
            Hotel hotel = new Hotel(-1L, hotelName, city, availableCount);
            hotelDao.insert(hotel);
            result = true;
        }

        return result;
    }


}
