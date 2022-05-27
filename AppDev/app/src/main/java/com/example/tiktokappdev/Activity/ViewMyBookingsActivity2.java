package com.example.tiktokappdev.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tiktokappdev.Adapter.AppointmentListViewAdapter;
import com.example.tiktokappdev.Adapter.MyCatsGridviewAdapter;
import com.example.tiktokappdev.DataManagers.AppointmentDataManager;
import com.example.tiktokappdev.DataManagers.MyCatsDataManager;
import com.example.tiktokappdev.DataModels.AppointmentDataModel;
import com.example.tiktokappdev.DataModels.MyCatsDataModel;
import com.example.tiktokappdev.R;
import com.example.tiktokappdev.SessionManager.SessionManager;

public class ViewMyBookingsActivity2 extends AppCompatActivity {


    AppointmentDataManager ADM;
    private String UserID;
    SessionManager sessionManager;
    private ListView listview_myappointmentpending;
    TextView tv_isthereappointment;

    MyCatsDataManager MCDM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_bookings2);


        // initialize DataManager
        ADM = new AppointmentDataManager();

        // initializa session manager
        sessionManager = new SessionManager(ViewMyBookingsActivity2.this);
        UserID = sessionManager.getUserID().toString();

        tv_isthereappointment = findViewById(R.id.tv_isthereappointment);
        listview_myappointmentpending = findViewById(R.id.listview_myappointmentpending);


        // list out all appointments booked
        final AppointmentDataModel[] appointment = ADM.GetAllAppointmentByUserID(UserID);
        // String noofmyappointment = Integer.toString(appointment.length);
        // tv_isthereappointment.setText("show = " + appointment);


        AppointmentListViewAdapter appointmentListViewAdapter = new AppointmentListViewAdapter(getApplicationContext(),  appointment);
        listview_myappointmentpending.setAdapter(appointmentListViewAdapter);




//        tv_isthereappointment.setText("My Bookings");
//
//        AppointmentListViewAdapter appointmentListViewAdapter = new AppointmentListViewAdapter(getApplicationContext(), appointment);
//        listview_myappointmentpending.setAdapter(appointmentListViewAdapter);





//        try
//        {
//
//        }
//        catch (Exception ex)
//        {
//            tv_isthereappointment.setText("error: " + ex);
//        }




//        listview_myappointmentpending.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//
//                // bring data to another page then delete
//                Intent intent = new Intent(ViewMyBookingsActivity2.this, AppointmentCancelActivity.class);
//                intent.putExtra("AppointmentID", appointment[position].getApptID());
//                intent.putExtra("Location", appointment[position].getLocation());
//                intent.putExtra("Date", appointment[position].getDate());
//                intent.putExtra("Time", appointment[position].getTime());
//                intent.putExtra("NoofPax", appointment[position].getNoOfPax());
//                intent.putExtra("TotalCost", appointment[position].getTotalCost());
//                intent.putExtra("ApptGetUserID", appointment[position].getApptUserID());
//
//            }
//        });


    }
}