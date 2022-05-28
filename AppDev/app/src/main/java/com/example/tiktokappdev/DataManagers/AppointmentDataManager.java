package com.example.tiktokappdev.DataManagers;

import android.util.Log;

import com.example.tiktokappdev.DataModels.AppointmentDataModel;
import com.example.tiktokappdev.Database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppointmentDataManager {

    // db connection
    DBConnection dbConnection;
    Connection connect;

    public AppointmentDataManager(){

    }


    // insert an appointment into the database
    public void AddAppointment (String Appt_Location, String Appt_Date, String Appt_Time, String Appt_NoofPax, String Appt_Total, String Appt_UserID)
    {
        // initialize DB Connection
        dbConnection = new DBConnection();

        // open connection
        connect = dbConnection.CONN();

        try
        {
            String queryAddAppointment = "Insert INTO Appointment (Appt_Location , Appt_Date , Appt_Time , Appt_NoofPax , Appt_Total , Appt_UserID) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement AddNewAppointmentRecord;
            AddNewAppointmentRecord = connect.prepareStatement(queryAddAppointment);
            AddNewAppointmentRecord.setString(1, Appt_Location);
            AddNewAppointmentRecord.setString(2, Appt_Date);
            AddNewAppointmentRecord.setString(3, Appt_Time);
            AddNewAppointmentRecord.setString(4, Appt_NoofPax);
            AddNewAppointmentRecord.setString(5, Appt_Total);
            AddNewAppointmentRecord.setString(6, Appt_UserID);
            AddNewAppointmentRecord.executeUpdate();
            connect.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }


    public AppointmentDataModel[] GetAllAppointmentByUserID(String getUserID)
    {
        // initialize DB Connection
        dbConnection = new DBConnection();

        // open connection
        connect = dbConnection.CONN();

        ArrayList<AppointmentDataModel> GetAppointmentList = new ArrayList<>();

        try
        {
            String queryGetAppointments = "select * from Appointment where Appt_UserID = ?";
            PreparedStatement stmt = connect.prepareStatement(queryGetAppointments);
            stmt.setString(1, getUserID);
            // stmt.setString(2, ApptStatus);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                String Appt_ID = rs.getString(1);
                String Appt_Location = rs.getString(2);
                String Appt_Date = rs.getString(3);
                String Appt_Time = rs.getString(4);
                String Appt_NoofPax = rs.getString(5);
                String Appt_Total = rs.getString(6);
                String Appt_UserID = rs.getString(7);

                AppointmentDataModel appointmentDataModel = new AppointmentDataModel(Appt_ID, Appt_Location, Appt_Date, Appt_Time, Appt_NoofPax, Appt_Total, Appt_UserID);
                GetAppointmentList.add(appointmentDataModel);

            }

            // close TesultSet and connection
            rs.close();
            connect.close();
            return GetAppointmentList.toArray(new AppointmentDataModel[0]);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Log.d("Get Appointment Failed",ex.toString());
        }

        return null;
    }


    public void DeleteBooking(String UserID, String ApptID)
    {
        // initialize DB Connection
        dbConnection = new DBConnection();

        // open connection
        connect = dbConnection.CONN();

        try
        {
            String DeleteAppointmentquery = "Delete Appointment where Appt_UserID = ? and Appt_ID = ?";
            PreparedStatement DeleteAppointment;
            DeleteAppointment = connect.prepareStatement(DeleteAppointmentquery);
            DeleteAppointment.setString(1, UserID);
            DeleteAppointment.setString(2, ApptID);
            DeleteAppointment.executeUpdate();
            connect.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }


}
