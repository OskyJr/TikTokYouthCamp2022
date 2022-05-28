package com.example.tiktokappdev.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tiktokappdev.DataManagers.AppointmentDataManager;
import com.example.tiktokappdev.DataManagers.UserDetailsDataManager;
import com.example.tiktokappdev.R;
import com.example.tiktokappdev.SessionManager.SessionManager;

public class AppointmentCancelActivity extends AppCompatActivity {

    SessionManager sessionManager;

    String receiveapptid;
    String receivelocation;
    String receivedate;
    String receivetime;
    String receivenoofpax;
    String receivetotalcost;
    String receiveapptuserid;

    TextView tv_apptlocation;
    TextView tv_apptdate;
    TextView tv_appttime;
    TextView tv_apptnoofpax;
    TextView tv_totalcost;

    Button buttonCancelAppointment;

    AppointmentDataManager ADM;
    UserDetailsDataManager UDDM;

    String UserID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_cancel);


        // initialize DataManager
        ADM = new AppointmentDataManager();
        UDDM = new UserDetailsDataManager();

        sessionManager = new SessionManager(getApplicationContext());
        UserID = sessionManager.getUserID().toString();

        tv_apptlocation = findViewById(R.id.tv_apptlocation);
        tv_apptdate = findViewById(R.id.tv_apptdate);
        tv_appttime = findViewById(R.id.tv_appttime);
        tv_apptnoofpax = findViewById(R.id.tv_apptnoofpax);
        tv_totalcost = findViewById(R.id.tv_appttotalcost);


        Intent intent = getIntent();
        receiveapptid = intent.getStringExtra("AppointmentID");
        receivelocation = intent.getStringExtra("Location");
        receivedate = intent.getStringExtra("Date");
        receivetime = intent.getStringExtra("Time");
        receivenoofpax = intent.getStringExtra("NoofPax");
        receivetotalcost = intent.getStringExtra("TotalCost");
        receiveapptuserid = intent.getStringExtra("ApptGetUserID");


        tv_apptlocation.setText(receivelocation);
        tv_apptdate.setText(receivedate);
        tv_appttime.setText(receivetime);
        tv_apptnoofpax.setText(receivenoofpax);
        tv_totalcost.setText(receivetotalcost);


        buttonCancelAppointment = findViewById(R.id.buttonCancelAppointment);
        buttonCancelAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new AlertDialog.Builder(AppointmentCancelActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Cancel Booking")
                        .setMessage("Do you want to delete this booking?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // delete the SELECTED appointment here
                                ADM.DeleteBooking(UserID, receiveapptid);



                                // show alert box to say appointment have been canceled
                                new AlertDialog.Builder(AppointmentCancelActivity.this)
                                        .setIcon(R.drawable.ic_correct)
                                        .setTitle("Booking Cancelled Successfully!")
                                        .setMessage("The Appointment have been Canceled.")
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {


                                                // GO BACK appointment after cancelling an appointment
                                                startActivity(new Intent(getApplicationContext(), NewBookingsActivity1.class));

                                            }
                                        })
                                        .show();




                            }
                        })
                        .setNegativeButton("No", null)
                        .show();


            }
        });



    }
}