package com.itis.servletsexample4.services;



import com.itis.servletsexample4.model.PlaceEntity;
import com.itis.servletsexample4.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class UserService {
    public void auth(ArrayList<PlaceEntity> notAvailablePlaces, User user, HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute("notAvailablePlaces", notAvailablePlaces);
        req.getSession().setAttribute("user", user);
        req.getSession().setAttribute("userId",user.getId());
        req.getSession().setAttribute("username",user.getUserName());
    }
    public boolean isNonAnonymous(HttpServletRequest req, HttpServletResponse resp) {
//        System.out.println(req.getSession().getAttribute("user"));
        return req.getSession().getAttribute("user") == null;
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().removeAttribute("notAvailablePlaces");
        req.getSession().removeAttribute("user");
        req.getSession().removeAttribute("userId");
        req.getSession().removeAttribute("username");

    }

    public User getUser(HttpServletRequest req, HttpServletResponse res) {
        // ToDo: check for existence
        return (User) req.getSession().getAttribute("user");
    }
}