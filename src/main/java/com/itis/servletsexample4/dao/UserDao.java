package com.itis.servletsexample4.dao;

import com.itis.servletsexample4.entity.Place;
import com.itis.servletsexample4.model.PlaceEntity;
import com.itis.servletsexample4.model.User;
import com.itis.servletsexample4.util.ConnectionProvider;
import com.itis.servletsexample4.util.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDao {
    private ConnectionProvider connectionProvider;

    //language=SQL
    private static final String SQL_SELECT = "SELECT * FROM users WHERE email = ? AND password = md5(?)";


    public UserDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public User getUserByEmailAndPassword(String email, String password) throws DbException {
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(SQL_SELECT);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet result = st.executeQuery();
            boolean hasResult = result.next();
            if (hasResult) {
                return new User(result.getInt("id"), result.getString("email"), result.getString("username"), result.getBoolean("online"));
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new DbException("Can't get user from DB", e);
        }
    }

}
