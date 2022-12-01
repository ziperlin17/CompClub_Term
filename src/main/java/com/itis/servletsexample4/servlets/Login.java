package com.itis.servletsexample4.servlets;

import com.itis.servletsexample4.dao.PlaceDao;
import com.itis.servletsexample4.dao.UserDao;
import com.itis.servletsexample4.model.PlaceEntity;
import com.itis.servletsexample4.model.User;
import com.itis.servletsexample4.services.UserService;
import com.itis.servletsexample4.util.DbException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.err;
import static java.lang.System.out;

@WebServlet("/login")
public class Login extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/WEB-INF/view/jsp/login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("email");
        String password = request.getParameter("password");
        if (username!=null && password!=null){
            try {
                User user = userDao.getUserByEmailAndPassword(username,password);
                if (user == null) {
                    response.sendRedirect(getServletContext().getContextPath()+"/Iogin");
                } else {
                    request.setAttribute("sucessLogin", false);
                    ArrayList<PlaceEntity> notAvailablePlaces = placeDao.getNotAvailablePlaces();
                    userService.auth(notAvailablePlaces,user,request,response);
                    response.sendRedirect(getServletContext().getContextPath()+"/place");
                }
            } catch (DbException e) {
                throw new ServletException(e);
            }
        }
    }
}
