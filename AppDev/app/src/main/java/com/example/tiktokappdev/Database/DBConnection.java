package com.example.tiktokappdev.Database;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    String ip = "sql8003.site4now.net";

    // this is default if you are using JTDS driver
    String classes = "net.sourceforge.jtds.jdbc.Driver";

    // Name of the database
    String db = "db_a86f1a_ttyc2022";

    // username and password are required for security
    String un = "db_a86f1a_ttyc2022_admin";
    String password = "tiktok@camp2022";


    @SuppressLint("NewApi")
    public Connection CONN() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL;

        try
        {
            Class.forName(classes);
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";" + "database=" + db + ";user=" + un + ";password=" + password + ";";
            conn = DriverManager.getConnection(ConnURL);
        }
        catch (SQLException se)
        {
            Log.e("error here 1 : ", se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("error here 2 : ", e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("error here 3 : ", e.getMessage());
        }
        return conn;

    }

}
