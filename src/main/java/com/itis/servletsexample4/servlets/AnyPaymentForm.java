package com.itis.servletsexample4.servlets;

import com.itis.servletsexample4.dao.PlaceDao;
import com.itis.servletsexample4.dao.UserDao;
import com.itis.servletsexample4.model.User;
import com.itis.servletsexample4.services.UserService;
import com.itis.servletsexample4.util.DbException;
import org.springframework.boot.web.servlet.server.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;

@WebServlet("/payment")
public class AnyPaymentForm extends HttpServlet {

    private PlaceDao placeDao;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        placeDao = (PlaceDao) getServletContext().getAttribute("placeDao");
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/jsp/payment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/WEB-INF/view/jsp/payment.jsp").forward(req, resp);
        System.out.println(req.getSession().getAttribute("user"));

        String a = (String) req.getParameter("arr");
        String b = (String) req.getParameter("hours");
        String c = (String) req.getParameter("topay");

        req.getSession().setAttribute("arr",a);
        req.getSession().setAttribute("hours",b);
        req.getSession().setAttribute("topay",c);

        System.out.println(a+b+c+"!!");
    }
}
