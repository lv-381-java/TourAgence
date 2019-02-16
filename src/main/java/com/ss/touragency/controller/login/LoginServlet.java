package com.ss.touragency.controller.login;

import com.ss.touragency.constants.Attribute;
import com.ss.touragency.constants.PathToJsp;
import com.ss.touragency.constants.PathToPage;
import com.ss.touragency.util.Context;
import org.apache.commons.lang.ObjectUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({PathToPage.HOME_PATH,PathToPage.LOGIN_PATH})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher(PathToJsp.LOGIN_JSP).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        try{
//            if(Context.getInstance().getClientService().validationClient(req)){
//                resp.sendRedirect(PathToPage.HOME_PATH);
//            }
//        }catch(NullPointerException e){
//            resp.sendRedirect(PathToPage.REGISTRATION_PATH);
//        }

        boolean result = false;

        if((req.getParameter(Attribute.LOGIN) != null) && (req.getParameter(Attribute.PASSWORD) != null)){
            try {
                result = Context.getInstance().getClientService().validationClient(req);
            }catch(NullPointerException e){
                req.setAttribute(Attribute.ERROR, "Invalid login or password. Try again!");
                req.getRequestDispatcher(PathToJsp.LOGIN_JSP).forward(req,resp);
            }
        }
        if(result){

            req.setAttribute(Attribute.LOGIN, req.getParameter(Attribute.LOGIN));
            req.getSession(true).setAttribute(Attribute.PASSWORD, req.getParameter(Attribute.PASSWORD));

            resp.sendRedirect(PathToPage.HOME_PATH);

        }
    }
}
