package com.itis.term.servlets;

import com.itis.term.dao.PlaceDao;
import com.itis.term.dao.UserDao;
import com.itis.term.model.PlaceEntity;
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
import java.util.ArrayList;

import static java.lang.System.out;

@WebServlet("/signup")
public class SignUp extends HttpServlet {
    private UserDao userDao;
    private UserService userService;
    private PlaceDao placeDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        placeDao = (PlaceDao) getServletContext().getAttribute("placeDao");
        userDao = (UserDao) getServletContext().getAttribute("userDao");
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/jsp/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        getServletContext().getRequestDispatcher("/WEB-INF/view/jsp/signup.jsp").forward(req, resp);
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(email+username+password);
        if(email!=null && username != null && password != null){
            try {
                // Single resp?
                User user = userDao.getUserByEmail(email);
                if(user == null){
                    ArrayList<PlaceEntity> notAvailablePlaces = placeDao.getNotAvailablePlaces();
                    userDao.registerUser(email,username,password);
                    User newUser = userDao.getUserByEmail(email);
                    userService.auth(notAvailablePlaces,newUser,req,resp);
                    resp.sendRedirect(getServletContext().getContextPath()+"/place");

                } else {
//                    req.setAttribute("sucessLogin", false);
//                    resp.sendRedirect(getServletContext().getContextPath()+"/Iogin");
//                    req.getSession().setAttribute("error","user exist");
                    resp.sendRedirect(getServletContext().getContextPath()+"/signupError");
                }
            } catch (DbException e) {
                e.printStackTrace();
            }
        }
    }
}
