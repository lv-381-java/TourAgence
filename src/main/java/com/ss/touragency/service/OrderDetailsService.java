package com.ss.touragency.service;

import com.ss.touragency.constants.Attribute;
import com.ss.touragency.dao.HotelDao;
import com.ss.touragency.dao.OrderDetailsDao;
import com.ss.touragency.entity.Client;
import com.ss.touragency.entity.Hotel;
import com.ss.touragency.entity.OrderDetails;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OrderDetailsService {

    // TODO: finish. assigned to Arsen
    public boolean createOrder(HttpServletRequest request) throws ParseException {

        boolean status = false;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String beginDate = (String) request.getSession().getAttribute(Attribute.BEGIN_DATE);
        String endDate = (String) request.getSession().getAttribute(Attribute.END_DATE);

        Hotel hotel = new Hotel();
        Client client = new Client();

        if (client != null && hotel != null && beginDate != null && endDate != null) {

            OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
            Date begin = (Date) formatter.parse(beginDate);
            Date end = (Date) formatter.parse(endDate);

            OrderDetails orderDetails = new OrderDetails(1L, client, hotel, begin, end);
            orderDetailsDao.insert(orderDetails);
            status = true;

        }
        return status;
    }

    public boolean updateOrderDetails (HttpServletRequest request) throws ParseException {
        boolean result = false;
        OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        if (request.getParameter(Attribute.HOTEL) != null && request.getParameter(Attribute.CITY) != null){
            Long orderId = Long.parseLong(request.getSession().getAttribute(Attribute.ORDER_ID).toString());
            OrderDetails orderDetails = orderDetailsDao.selectById(orderId);

//            orderDetails.setHotel(request.getParameter(Attribute.HOTEL));
//            orderDetails.setCity(request.getParameter(Attribute.CITY));
            orderDetails.setBeginDate(formatter.parse(request.getParameter(Attribute.BEGIN_DATE)));
            orderDetails.setEndDate(formatter.parse(request.getParameter(Attribute.END_DATE)));
            orderDetailsDao.updateById(orderDetails, orderId);
            result = true;
        }
        return result;
    }
}