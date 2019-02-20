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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class OrderDetailsService {

    // TODO: finish. assigned to Arsen
    public boolean createOrder(HttpServletRequest request) throws ParseException, SQLException {

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

    public OrderDetails getOrder(HttpServletRequest request) throws SQLException {
        OrderDetailsDao orderDetailsDao = new OrderDetailsDao();

        if (request.getSession().getAttribute(Attribute.ORDER_ID) != null
                && isExistOrder(Long.parseLong((String) request.getSession().getAttribute(Attribute.ORDER_ID)))) {

            Long id = Long.parseLong((String) request.getSession().getAttribute(Attribute.ORDER_ID));
            orderDetailsDao.selectById(id);
        }
        return null;
    }

    public List<OrderDetails> getOrderDetailsList(HttpServletRequest request) throws SQLException {
        OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
        List<OrderDetails> orderDetailsList = orderDetailsDao.selectAll();
        return orderDetailsList;
    }


    public List<OrderDetails> getOrderFromAllOrders(Long id) throws SQLException {
        OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
        List<OrderDetails> order = orderDetailsDao.selectOrderFromAllOrders(id);
        return order;
    }


    private boolean isExistOrder(Long id) throws SQLException {
        boolean result = false;
        try {
            OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
            orderDetailsDao.selectById(id);
            result = true;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteOrder(HttpServletRequest request) throws SQLException {
        boolean result = false;
        OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
        if (request.getParameter(Attribute.ORDER_ID) != null && isExistOrder(Long.parseLong(request.getParameter(Attribute.ORDER_ID)))) {
            Long id = Long.parseLong(request.getParameter(Attribute.ORDER_ID));
            orderDetailsDao.deleteById(id);
            result = true;
        }
        return result;
    }

    public boolean updateOrderDetails(HttpServletRequest request) throws ParseException, SQLException {
        boolean result = false;
        OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        if (request.getParameter(Attribute.HOTEL) != null && request.getParameter(Attribute.CITY) != null) {
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
