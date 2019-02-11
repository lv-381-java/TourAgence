package com.ss.touragency.service;

import com.ss.touragency.constants.Attribute;
import com.ss.touragency.dao.OrderDetailsDao;
import com.ss.touragency.entity.Client;
import com.ss.touragency.entity.Hotel;
import com.ss.touragency.entity.OrderDetails;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OrderDetailsService {

    // TODO: finish. assigned to Arsen
    public boolean createOrder(HttpServletRequest request) throws ParseException {

        boolean status = false;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

//        String client = (String) request.getSession().getAttribute(Attribute.CLIENT);
//        String hotel = (String) request.getSession().getAttribute(Attribute.HOTEL);
        String beginDate = (String) request.getSession().getAttribute(Attribute.BEGIN_DATE);
        String endDate = (String) request.getSession().getAttribute(Attribute.END_DATE);

        Hotel hotel = new Hotel();
        Client client = new Client();

        if (client != null && hotel != null && beginDate != null && endDate != null) {

            OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
            Date begin = (Date) formatter.parse(beginDate);
            Date end = (Date) formatter.parse(endDate);

            OrderDetails orderDetails = new OrderDetails(-1L, client, hotel, begin, end);
            orderDetailsDao.insert(orderDetails);
            status = true;

        }
        return status;
    }
}
