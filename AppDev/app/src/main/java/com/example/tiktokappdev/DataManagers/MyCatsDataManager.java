package com.example.tiktokappdev.DataManagers;

import android.content.Context;
import android.util.Log;

import com.example.tiktokappdev.DataModels.MyCatsDataModel;
import com.example.tiktokappdev.Database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MyCatsDataManager {

    // db connection
    DBConnection dbConnection;
    Connection connect;
    Context cxt;

    public MyCatsDataManager(Context context)
    {
        cxt = context;
    }

    public MyCatsDataManager(){ }


    // get all records of the cats
    public MyCatsDataModel[] GetAllCats()
    {
        // initialize DB Connection
        dbConnection = new DBConnection();

        // open connection
        connect = dbConnection.CONN();

        // array list
        ArrayList<MyCatsDataModel> MyCatsLists = new ArrayList<>();

        try
        {
            String query = "select * from Cats";
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String ID = rs.getString(1);
                String Name = rs.getString(2);
                String Age = rs.getString(3);
                String Breed = rs.getString(4);
                String Description = rs.getString(5);
                String Image = rs.getString(6);
//                image is a .png or .jpg
                Integer ImageInt = cxt.getResources().getIdentifier(Image.substring(0, Image.indexOf(".")), "drawable", cxt.getPackageName());


                MyCatsDataModel MyCatsDataModel = new MyCatsDataModel(ID, Name, Age, Breed, Description, ImageInt);
                MyCatsLists.add(MyCatsDataModel);
            }
            // close TesultSet and connection
            rs.close();
            connect.close();
            return MyCatsLists.toArray(new MyCatsDataModel[0]);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Log.d("GetCatsFail",ex.toString());
        }
        return null;

    }



    // get 1 record of cats by ID
    public MyCatsDataModel GetCatsInformationByID(String ID)
    {
        // initialize DB Connection
        dbConnection = new DBConnection();

        // open connection
        connect = dbConnection.CONN();

        try
        {
            String query = "select * from Cats where Cat_ID = ?";
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String CatID = rs.getString(1);
                String Name = rs.getString(2);
                String Age = rs.getString(3);
                String Breed = rs.getString(4);
                String Description = rs.getString(5);
                String Image = rs.getString(6);
//                image is a .png or .jpg
                Integer ImageInt = cxt.getResources().getIdentifier(Image.substring(0, Image.indexOf(".")), "drawable", cxt.getPackageName());

                return new MyCatsDataModel(CatID , Name, Age, Breed, Description, ImageInt);
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
