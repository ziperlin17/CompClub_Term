package com.itis.term.servlets;

import com.itis.term.dao.PlaceDao;
import com.itis.term.services.UserService;
import com.itis.term.util.DbException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAllBooking")
public class deleteAllBooking extends HttpServlet {
    private PlaceDao placeDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        placeDao = (PlaceDao) getServletContext().getAttribute("placeDao");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            placeDao.deleteAllBooking();
            //TODO: delete existing timer!!!
        } catch (DbException e) {
            e.printStackTrace();
        }
        req.getSession().removeAttribute("notAvailablePlaces");
        try {
            req.getSession().setAttribute("notAvailablePlaces", placeDao.getNotAvailablePlaces());
        } catch (DbException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(getServletContext().getContextPath()+"/place");
    }
}
