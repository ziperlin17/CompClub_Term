package com.itis.servletsexample4.dao;

import com.itis.servletsexample4.entity.Place;
import com.itis.servletsexample4.model.PlaceEntity;
import com.itis.servletsexample4.util.ConnectionProvider;
import com.itis.servletsexample4.util.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaceDao {
    private ConnectionProvider connectionProvider;


    public PlaceDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }
    public ArrayList<PlaceEntity> getPlaceStatuses() throws DbException {
        ArrayList<PlaceEntity> placeList = new ArrayList<>();
        try {
            Statement st = this.connectionProvider.getCon().createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM places pl");
            while(result.next()){

                int id = result.getInt(1);
                Boolean vip_status = result.getBoolean(2);
                Boolean status = result.getBoolean(3);
                String time_in = result.getString(4);
                String time_out = result.getString(5);
                int current_user = result.getInt(6);
                PlaceEntity place = new PlaceEntity(id,vip_status,status,time_in,time_out,current_user);
                placeList.add(place);
            }

            return placeList;
        } catch (SQLException e) {
            throw new DbException("Can't get count of books in DB.", e);
        }
    }

    public  PlaceEntity getPlaceStatusAndTime(int placeId) throws DbException {
        try {
            Statement st = this.connectionProvider.getCon().createStatement();
            PreparedStatement preparedStatement = connectionProvider.getCon().prepareStatement("SELECT * FROM places pl WHERE pl.id=?");
//            ResultSet result = st.executeQuery("SELECT pl.id, pl.status, pl.time_in, pl.time_out FROM places pl WHERE pl.id=placeId");
            preparedStatement.setInt(1, placeId);
            ResultSet result = preparedStatement.executeQuery();
            PlaceEntity place = null;
            while (result.next()) {
                Boolean vip_status = result.getBoolean(2);
                Boolean status = result.getBoolean(3);
                String time_in = result.getString(4);
                String time_out = result.getString(5);
                int current_user = result.getInt(6);
                place = new PlaceEntity(placeId, vip_status, status, time_in, time_out,current_user);
            }
            return place;
        } catch (SQLException e) {
            throw new DbException("Can't get count of books in DB.", e);
        }
    }

    public void updatePlacesIn(boolean status, String time_in, String time_out, int current_user, String current_username, int placeId) throws DbException {
        try {
            Statement st = this.connectionProvider.getCon().createStatement();
            PreparedStatement preparedStatement = connectionProvider.getCon().prepareStatement("UPDATE places set status = ?, time_in = ?, time_out = ?, currentuser = ?, current_username = ? where id = ?");
            preparedStatement.setBoolean(1,status);
            preparedStatement.setString(2,time_in);
            preparedStatement.setString(3,time_out);
            preparedStatement.setInt(4,current_user);
            preparedStatement.setString(5,current_username);
            preparedStatement.setInt(6,placeId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("updated in intPlaceId = " + placeId);
        } catch (SQLException e) {
            throw new DbException("Can't update.", e);
        }
    }

    public void updatePlacesOut(int placeId) throws DbException {
        try {
            PreparedStatement preparedStatement = connectionProvider.getCon().prepareStatement("UPDATE places set " +
                    "status = true, time_in = null, time_out = null, currentuser = null " +
                    "where id = ?");
            preparedStatement.setInt(1,placeId);
//            preparedStatement.setString(1,time_in);
//            preparedStatement.setString(1,time_out);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DbException("Can't update.", e);
        }
    }
    public ArrayList<PlaceEntity> getNotAvailablePlaces() throws DbException {
        ArrayList<PlaceEntity> notAvalablePlaces = new ArrayList<>();
        try {
            Statement st = this.connectionProvider.getCon().createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM places pl WHERE pl.status=false");
            while(result.next()){
                int id = result.getInt(1);
                Boolean vip_status = result.getBoolean(2);
                Boolean status = result.getBoolean(3);
                String time_in = result.getString(4);
                String time_out = result.getString(5);
                int current_user = result.getInt(6);
                String current_username = result.getString(7);
                PlaceEntity place = new PlaceEntity(id,vip_status,status,time_in,time_out,current_user,current_username);
                notAvalablePlaces.add(place);
            }

            return notAvalablePlaces;
        } catch (SQLException e) {
            throw new DbException("Can't get count of books in DB.", e);
        }
    }





    public List<Place> getPlaces() {
        return new ArrayList<Place>();
    }

}
