package com.ss.touragency.service;

import com.ss.touragency.constants.Attribute;
import com.ss.touragency.dao.OrderDetailsDao;
import com.ss.touragency.entity.OrderDetails;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class OrderDetailsService {

    // FIXME: finish
    public boolean createOrder(HttpServletRequest request) {
        boolean status = false;

        String client = (String) request.getSession().getAttribute(Attribute.CLIENT);
        String hotel = (String) request.getSession().getAttribute(Attribute.HOTEL);
        String beginDate = (String) request.getSession().getAttribute(Attribute.BEGIN_DATE);
        String endDate = (String) request.getSession().getAttribute(Attribute.END_DATE);

        if (client != null && hotel != null && beginDate != null && endDate != null) {
            OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
//            OrderDetails orderDetails = new OrderDetails(-1L, client, hotel, beginDate, endDate);
        }
        return status;
    }
}
