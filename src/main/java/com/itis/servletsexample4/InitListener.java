package com.itis.servletsexample4;

import com.itis.servletsexample4.dao.PlaceDao;
import com.itis.servletsexample4.dao.UserDao;
import com.itis.servletsexample4.services.UserService;
import com.itis.servletsexample4.util.ConnectionProvider;
import com.itis.servletsexample4.util.DbException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionProvider connectionProvider = ConnectionProvider.getInstance();
            sce.getServletContext().setAttribute("placeDao", new PlaceDao(connectionProvider));
            sce.getServletContext().setAttribute("userDao", new UserDao(connectionProvider));
            sce.getServletContext().setAttribute("userService", new UserService());
        } catch (DbException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}