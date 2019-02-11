package com.ss.touragency.service;

import com.ss.touragency.constants.Attribute;
import com.ss.touragency.dao.HotelDao;
import com.ss.touragency.entity.City;
import com.ss.touragency.entity.Hotel;

import javax.servlet.http.HttpServletRequest;

public class HotelService {


    // TODO: find out if City needed. assigned to Arsen
    public boolean createHotel(HttpServletRequest request) {
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

    public boolean updateHotel(HttpServletRequest request){
        boolean result = false;
        HotelDao hotelDao = new HotelDao();

        if (request.getParameter(Attribute.HOTEL_NAME) != null){
            Long hotelId = Long.parseLong(request.getSession().getAttribute(Attribute.HOTEL_ID).toString());
            Hotel hotel = hotelDao.selectById(hotelId);
            hotel.setHotelName(request.getParameter(Attribute.HOTEL_NAME));
//            hotel.setCity(request.getParameter(Attribute.CITY));
            hotel.setAvailableCount(Integer.parseInt(request.getParameter(Attribute.AVAILABLE_COUNT)));
            hotelDao.updateById(hotel, hotelId);
            result = true;
        }
        return result;
    }

    public Hotel getHotel(HttpServletRequest request) {
        HotelDao hotelDao = new HotelDao();

        if (request.getSession().getAttribute(Attribute.COUNTRY_ID) != null &&
                isExistItem(Long.parseLong((String) request.getSession().getAttribute(Attribute.COUNTRY_ID)))) {
            Long countryId = Long.parseLong( (String) request.getSession().getAttribute(Attribute.COUNTRY_ID));

            return hotelDao.selectById(countryId);
        }
        return null;
    }

    private boolean isExistItem(Long id) {
        boolean result = false;
        try {
            HotelDao hotelDao = new HotelDao();
            hotelDao.selectById(id);
            result = true;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return result;
    }


}
