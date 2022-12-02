package com.itis.term.dao;

import com.itis.term.model.User;
import com.itis.term.util.ConnectionProvider;
import com.itis.term.util.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public User getUserByEmail(String username) throws DbException {
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement("SELECT * FROM users WHERE email = ?");
            st.setString(1, username);
            ResultSet result = st.executeQuery();
            boolean hasOne = result.next();
            if(hasOne) {
                System.out.println("someone returned");
                return new User(result.getInt("id"), result.getString("email"), result.getString("username"), result.getBoolean("online"));
            } else {
                System.out.println("returned null");
                return null;
            }
        } catch (SQLException e) {
            throw new DbException("Can't get user from db.", e);
        }
    }

    public void registerUser(String email, String username, String password) throws DbException {
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement("INSERT INTO users (email, password, online, username) VALUES  (?, md5(?), false, ?)");
            st.setString(1, email);
            st.setString(2, password);
            st.setString(3, username);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException("Can't get user from db.", e);
        }
    }

}
