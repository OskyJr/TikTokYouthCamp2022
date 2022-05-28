package com.example.tiktokappdev.DataManagers;


import com.example.tiktokappdev.DataModels.UserDetailsDataModel;
import com.example.tiktokappdev.Database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDetailsDataManager {

    // db connection
    DBConnection dbConnection;
    Connection connect;

    public UserDetailsDataModel GetLoginStatus(String Email, String Password)
    {
        // initialize DB Connection
        dbConnection = new DBConnection();

        // open connection
        connect = dbConnection.CONN();

        try
        {
            String query = "select * from UserDetails where Email = ? and Password = ?";
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, Email);
            stmt.setString(2, Password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ID = rs.getString(1);
                String Name = rs.getString(2);
                String Roles = rs.getString(3);
                String email = rs.getString(4);
                String ContactNumber = rs.getString(5);
                String DateofBirth = rs.getString(6);
                String Gender = rs.getString(7);
                String password = rs.getString(8);

                return new UserDetailsDataModel(ID, Name, Roles, email, ContactNumber, DateofBirth, Gender, password);
            }
            // close TesultSet and connection
            rs.close();
            connect.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;

    }



    public UserDetailsDataModel GetUserProfileDetails(String UserID)
    {
        // initialize DB Connection
        dbConnection = new DBConnection();

        // open connection
        connect = dbConnection.CONN();

        try
        {
            String query = "select * from UserDetails where UserID = ?";
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, UserID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ID = rs.getString(1);
                String Name = rs.getString(2);
                String Roles = rs.getString(3);
                String email = rs.getString(4);
                String ContactNumber = rs.getString(5);
                String DateofBirth = rs.getString(6);
                String Gender = rs.getString(7);
                String password = rs.getString(8);

                return new UserDetailsDataModel(ID, Name, Roles, email, ContactNumber, DateofBirth, Gender, password);
            }
            // close ResultSet and connection
            rs.close();
            connect.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }




}
