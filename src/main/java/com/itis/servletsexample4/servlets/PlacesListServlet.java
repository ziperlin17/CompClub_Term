package com.itis.servletsexample4.servlets;


import com.itis.servletsexample4.dao.PlaceDao;
import com.itis.servletsexample4.model.PlaceEntity;
import com.itis.servletsexample4.util.DbException;
import org.springframework.boot.web.servlet.server.Session;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/place")
public class PlacesListServlet extends HttpServlet {
    private PlaceDao placeDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        placeDao = (PlaceDao) config.getServletContext().getAttribute("placeDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("notAvailablePlaces");
        try {
            req.getSession().setAttribute("notAvailablePlaces", placeDao.getNotAvailablePlaces());
        } catch (DbException e) {
            e.printStackTrace();
        }

        try {
            String place = "place";
            ArrayList<PlaceEntity> places = placeDao.getPlaceStatuses();
            for (int i = 0; i < places.size(); i++) {
                if (places.get(i).getStatus() && places.get(i).getVipStatus()) {
                    req.setAttribute(place+places.get(i).getId().toString(), "/focused/resourses/yepvip1.png");
                }
                else if (places.get(i).getStatus() && !places.get(i).getVipStatus()) {
                    req.setAttribute(place+places.get(i).getId().toString(), "/focused/resourses/yep1.png");
                }
                else if (!places.get(i).getStatus() && places.get(i).getVipStatus()) {
                    req.setAttribute(place+places.get(i).getId().toString(), "/focused/resourses/novip1.png");
                }
                else if (!places.get(i).getStatus() && !places.get(i).getVipStatus()) {
                    req.setAttribute(place+places.get(i).getId().toString(), "/focused/resourses/no1.png");
                }
            }


        } catch (DbException e) {

            throw new ServletException(e);
        }
        req.getSession().getAttribute("username");
        getServletContext().getRequestDispatcher("/WEB-INF/view/jsp/prof.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("notAvailablePlaces");
        try {
            req.getSession().setAttribute("notAvailablePlaces", placeDao.getNotAvailablePlaces());
        } catch (DbException e) {
            e.printStackTrace();
        }
        try {
            String place = "place";
            ArrayList<PlaceEntity> places = placeDao.getPlaceStatuses();
            for (int i = 0; i < places.size(); i++) {
                if (places.get(i).getStatus() && places.get(i).getVipStatus()) {
                    req.setAttribute(place+places.get(i).getId().toString(), "/focused/resourses/yepvip1.png");
                }
                else if (places.get(i).getStatus() && !places.get(i).getVipStatus()) {
                    req.setAttribute(place+places.get(i).getId().toString(), "/focused/resourses/yep1.png");
                }
                else if (!places.get(i).getStatus() && places.get(i).getVipStatus()) {
                    req.setAttribute(place+places.get(i).getId().toString(), "/focused/resourses/novip1.png");
                }
                else if (!places.get(i).getStatus() && !places.get(i).getVipStatus()) {
                    req.setAttribute(place+places.get(i).getId().toString(), "/focused/resourses/no1.png");
                }
            }


        } catch (DbException e) {

            throw new ServletException(e);
        }
        req.getSession().getAttribute("username");
        getServletContext().getRequestDispatcher("/WEB-INF/view/jsp/prof.jsp").forward(req, resp);
    }
}