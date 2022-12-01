package com.itis.term.servlets;

import com.itis.term.dao.PlaceDao;
import com.itis.term.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
