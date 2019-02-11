package com.ss.touragency;

import com.ss.touragency.dao.CityDao;
import com.ss.touragency.dao.ClientDao;
import com.ss.touragency.dao.CountryDao;
import com.ss.touragency.dao.HotelDao;
import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.City;
import com.ss.touragency.entity.Client;
import com.ss.touragency.entity.Country;
import com.ss.touragency.entity.Hotel;
import com.ss.touragency.service.CityService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main( String[] args ) throws SQLException {

//        CountryDao c = new CountryDao();
//        Country country = new Country("CountryName2");

//        System.out.println(c.selectById((long)5));
//        c.deleteById((long) 10);
//        c.updateById(country, (long)10);
//        c.insert(country);

//        System.out.println(c.selectAll());
//        System.out.println(c.selectById(3L));

//        c.deleteById(8l);
//        Country co = new Country("Romania");
//      c.updateById(co,9l);
//        c.deleteById(9l);
//        System.out.println(c.selectAll());

//        CityDao city = new CityDao();
//        City city2 = new City("Neapol",c.selectById(5l));
//        City city3 = new City("Bordo",c.selectById(4l));
//        city.insert(city2);
//        System.out.println(city.selectById(3L));
//        city.updateById(city3,9L);
//        city.deleteById(10l);


//        City city5= new City("Rivne",c.selectById(1L));
//        city.insert(city5);
//        System.out.println(city.selectAll());


//        CityService cityService = new CityService();
//        Map<Country, List<City>> map = cityService.selectAllCountrisWithCities();
//
//        for(Map.Entry<Country, List<City>> entry : map.entrySet()){
//
//            Country cou = entry.getKey();
//            List<City> cityList = entry.getValue();
//            System.out.println(cou.getCountryName() + " : " + cityList);
//
//        }
//        HotelDao hd = new HotelDao();
//        hd.insert(new Hotel("Tourist",city.selectById(1l),300));
//        System.out.println(hd.selectAll());
//        System.out.println(hd.selectAll());
//        System.out.println(hd.selectById(4L));
//        Hotel h3= new Hotel("Edem",city.selectById(1l),150);
//        hd.updateById(h3,12l);
//        System.out.println(hd.selectAll());


    }
}
