package com.example.tiktokappdev.DataModels;

public class UserDetailsDataModel {

    private String UserID;
    private String Name;
    private String Roles;  // Member or Admin
    private String Email;
    private String ContactNumber;
    private String DateofBirth;
    private String Gender;
    private String Password;


    public UserDetailsDataModel(String userID, String name, String roles, String email, String contactNumber, String dateofBirth, String gender, String password) {
        UserID = userID;
        Name = name;
        Roles = roles;
        Email = email;
        ContactNumber = contactNumber;
        DateofBirth = dateofBirth;
        Gender = gender;
        Password = password;
    }


    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRoles() {
        return Roles;
    }

    public void setRoles(String roles) {
        Roles = roles;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        DateofBirth = dateofBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }



}
