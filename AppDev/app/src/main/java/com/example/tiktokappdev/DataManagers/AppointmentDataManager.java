package com.example.tiktokappdev.DataManagers;

import com.example.tiktokappdev.Database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


}
