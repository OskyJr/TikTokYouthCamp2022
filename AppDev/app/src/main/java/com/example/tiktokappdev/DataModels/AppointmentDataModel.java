package com.example.tiktokappdev.DataModels;

public class AppointmentDataModel {

    private String ApptID;
    private String Location;
    private String Date;
    private String Time;
    private String NoofPax;
    private String TotalCost;
    private String Appt_UserID;


    public AppointmentDataModel(String apptID, String location, String date, String time, String noofpax, String totalcost, String appt_userid) {
        ApptID = apptID;
        this.Location = location;
        this.Date = date;
        this.Time = time;
        this.NoofPax = noofpax;
        this.TotalCost = totalcost;
        this.Appt_UserID = appt_userid;
    }


    public String getApptID() {
        return ApptID;
    }
    public void setApptID(String apptID) {
        ApptID = apptID;
    }

    public String getLocation() {return Location;}
    public void setLocation(String location) {Location = location;}

    public String getDate() {return Date;}
    public void setDate(String date) {Date = date;}

    public String getTime() {return Time;}
    public void setTime(String time) {Time = time;}

    public String getNoOfPax() {return NoofPax;}
    public void setNoOfPax(String noOfPax) {NoofPax = noOfPax;}

    public String getTotalCost() {return TotalCost;}
    public void setTotalCost(String totalCost) {TotalCost = totalCost;}

    public String getApptUserID() {return Appt_UserID;}
    public void setApptUserID(String appt_userid) {Appt_UserID = appt_userid;}

}
