package com.ss.touragency.controller.hotel;

import com.ss.touragency.constants.PathToJsp;
import com.ss.touragency.constants.PathToPage;
import com.ss.touragency.entity.City;
import com.ss.touragency.entity.Country;
import com.ss.touragency.entity.Hotel;
import com.ss.touragency.util.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(PathToPage.HOTEL_INFO)
public class HotelInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Hotel> hotelList = Context.getInstance().getHotelService().getHotelList(request);
        request.setAttribute("hotel", hotelList);

        List<Country> countryList = Context.getInstance().getCountryService().getCountryList(request);
        request.setAttribute("country", countryList);

        List<City> cityList = Context.getInstance().getCityService().getCityList(request);
        request.setAttribute("city", cityList);

        request.getRequestDispatcher(PathToJsp.HOTEL_JSP).forward(request, response);

        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            int country = Integer.parseInt(request.getParameter("country"));
//            switch (country) {
//                case 1:
//                    out.print(
//                            "<option value='1'>Product Name 1 For Category 2</option>" +
//                                    "<option value='2'>Product Name 2 For Category 2</option>" +
//                                    "<option value='3'>Product Name 3 For Category 2</option>"
//                    );
//                    break;
//                case 2:
//                    out.print(
//                            "<option value='1'>Product Name 1 For Category 3</option>" +
//                                    "<option value='2'>Product Name 2 For Category 3</option>" +
//                                    "<option value='3'>Product Name 3 For Category 3</option>"
//                    );
//                    break;
//                default:
//                    out.print(
//                            "<option value='1'>Product Name 1 For Category 1</option>" +
//                                    "<option value='2'>Product Name 2 For Category 1</option>" +
//                                    "<option value='3'>Product Name 3 For Category 1</option>"
//                    );
//                    break;
//            }
//        } catch (Exception ex) {
//            out.print("Error getting product name..." + ex.toString());
//        } finally {
//            out.close();
//        }

//        !!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String countryName = request.getParameter("country");
        String cityName = request.getParameter("city");

        if (countryName.equals("All")) {
            List<Country> countryList = Context.getInstance().getCountryService().getCountryList(request);
            request.setAttribute("country", countryList);
            List<City> cityList = Context.getInstance().getCityService().getCityList(request);
            request.setAttribute("city", cityList);
            List<Hotel> hotelList = Context.getInstance().getHotelService().getHotelList(request);
            request.setAttribute("hotel", hotelList);
        } else if (!countryName.equals("All") && cityName.equals("All")) {
            List<Country> countryList = new ArrayList<>();
            Country country = Context.getInstance().getCountryService().getCountryByName(countryName);
            countryList.add(country);
            request.setAttribute("country", countryList);

            List<City> cityList = Context.getInstance().getCityService().getCityByCountry(country.getIdCountry());
            request.setAttribute("city", cityList);

            List<Hotel> hotelList = new ArrayList<>();
            for (City city : cityList) {
                Long cityId = city.getCityId();
                List<Hotel> hotels = Context.getInstance().getHotelService().getHotelsByCity(cityId);
                hotelList.addAll(hotels);
            }
            request.setAttribute("hotel", hotelList);
        } else if (!countryName.equals("All") && !cityName.equals("All")) {
            List<Country> countryList = new ArrayList<>();
            Country country = Context.getInstance().getCountryService().getCountryByName(countryName);
            countryList.add(country);
            request.setAttribute("country", countryList);

            City city = Context.getInstance().getCityService().getCityByName(cityName);
            List<City> cityList = new ArrayList<>();
            cityList.add(city);
            request.setAttribute("city", cityList);

            for (City cityEntity : cityList) {
                Long cityId = cityEntity.getCityId();
                List<Hotel> hotels = Context.getInstance().getHotelService().getHotelsByCity(cityId);
                request.setAttribute("hotel", hotels);
            }
        }
        request.getRequestDispatcher(PathToJsp.HOTEL_JSP).forward(request, response);

    }
}
