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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/jsp/payment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/WEB-INF/view/jsp/payment.jsp").forward(req, resp);
        System.out.println(req.getSession().getAttribute("user"));

        String chosenPlaces = (String) req.getParameter("chosenPlaces");
        String chosenHours = (String) req.getParameter("chosenHours");
        String toPay = (String) req.getParameter("toPay");

        req.getSession().setAttribute("chosenPlaces",chosenPlaces);
        req.getSession().setAttribute("chosenHours",chosenHours);
        req.getSession().setAttribute("toPay",toPay);
    }
}
