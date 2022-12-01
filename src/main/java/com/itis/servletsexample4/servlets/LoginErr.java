package com.itis.servletsexample4.servlets;

import com.itis.servletsexample4.dao.UserDao;
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

@WebServlet("/Iogin")
public class LoginErr extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/jsp/LoginErr.jsp").forward(request, response);

    }
}