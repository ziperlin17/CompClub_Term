package com.itis.term.servlets;

import com.itis.term.dao.PlaceDao;
import com.itis.term.model.User;
import com.itis.term.services.UserService;
import com.itis.term.util.DbException;

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
import java.util.Timer;

@WebServlet("/payment/check")
public class AfterSuccessPay extends HttpServlet {
    private PlaceDao placeDao;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        placeDao = (PlaceDao) getServletContext().getAttribute("placeDao");
        userService = (UserService) getServletContext().getAttribute("userService");
    }


    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String arr = String.valueOf(request.getSession().getAttribute("arr"));
        String hrs = String.valueOf(request.getSession().getAttribute("hours"));
        String topay = String.valueOf(request.getSession().getAttribute("topay"));


        request.getSession().removeAttribute("arr");
        request.getSession().removeAttribute("hours");

        String cardnumber = request.getParameter("cardnumber");
        String holder = request.getParameter("holder");
        String moneyValue = request.getParameter("moneyValue");
        String cvv = request.getParameter("cvv");
        String expireMM = request.getParameter("expireMM");
        String expireYY = request.getParameter("expireYY");

        
        User user = (User) request.getSession().getAttribute("user");

        ArrayList<Integer> placesIdList = new ArrayList<>();
        for (int i = 0; i < arr.split(",").length; i++) {
            placesIdList.add(Integer.parseInt(arr.split(",")[i]));
        }


        if (Integer.parseInt(moneyValue)>Integer.parseInt(topay)) {
            for (int i = 0; i < placesIdList.size(); i++) {
                try {
                    DateTimeFormatter date_time = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                    LocalDateTime now = LocalDateTime.now();
                    Boolean status = placeDao.getPlaceStatusAndTime(placesIdList.get(i)).getStatus();
                    System.out.println(status);
                    String timeOut = placeDao.getPlaceStatusAndTime(placesIdList.get(i)).getTime_out();
                    Integer currentUser = placeDao.getPlaceStatusAndTime(placesIdList.get(i)).getCurrent_user();

                    if (status==true) {
                        placeDao.updatePlacesIn(false, date_time.format(now), date_time.format(now.plusHours(Integer.parseInt(hrs))), user.getId(), user.getUserName(), placesIdList.get(i));
                        request.getSession().removeAttribute("notAvailablePlaces");
                        request.getSession().setAttribute("notAvailablePlaces", placeDao.getNotAvailablePlaces());
                        Timer t = new java.util.Timer();
                        int finalI = i;
                        t.schedule(
                                new java.util.TimerTask() {
                                    @Override
                                    public void run() {
                                        try {
                                            placeDao.updatePlacesOut(placesIdList.get(finalI));
                                        } catch (DbException e) {
                                            e.printStackTrace();
                                        }
                                        t.cancel();
                                    }
                                },
                                3600000L *Integer.parseInt(hrs)
                        );
                    }
                    else {
                        System.out.println("already taken");
                    }
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
            request.getSession().removeAttribute("topay");
            response.sendRedirect(request.getContextPath()+"/place");

        } else {
            request.getSession().removeAttribute("topay");
            response.sendRedirect(request.getContextPath()+"/paymentError");
        }
    }
}
