package com.itis.servletsexample4.servlets;

import com.itis.servletsexample4.dao.PlaceDao;
import com.itis.servletsexample4.entity.Place;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/placecontrol")
public class PlaceControl extends HttpServlet {
    private PlaceDao placeDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        placeDao = (PlaceDao) getServletContext().getAttribute("placeDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Create book");
    }
}