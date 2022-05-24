package com.example.tiktokappdev.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiktokappdev.DataManagers.UserDetailsDataManager;
import com.example.tiktokappdev.R;
import com.example.tiktokappdev.SessionManager.SessionManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NewBookingsActivity1 extends AppCompatActivity {


    private Spinner spinner_bookingtime;
    private Spinner spinner_noofpax;
    private Button buttonSelectDate;
    private Button buttonCalculateCost;
    private Button buttonConfirmBooking;
    private Button buttonReset;
    private TextView tv_totalcost;
    private TextView tv_totalcosttag;
    private TextView tv_errormessage;

    DatePickerDialog.OnDateSetListener onDateSetListener;
    List<String> PublicHoliday = new ArrayList<String>();

    String UserName;
    String UserEmail;
    UserDetailsDataManager UDDM;
    SessionManager sessionManager;
    private TextView tv_LoginSessionUserID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newbookings1);


        spinner_bookingtime = findViewById(R.id.spinner_bookingtime);
        spinner_noofpax = findViewById(R.id.spinner_noofpax);
        buttonSelectDate = findViewById(R.id.buttonSelectDate);
        buttonCalculateCost = findViewById(R.id.buttonCalculateCost);
        buttonConfirmBooking = findViewById(R.id.buttonConfirmBooking);
        buttonReset = findViewById(R.id.buttonReset);
        tv_totalcosttag = findViewById(R.id.tv_totalcosttag);
        tv_totalcost = findViewById(R.id.tv_totalcost);
        tv_errormessage = findViewById(R.id.tv_errormessage);


        // Buttons to Disable when launched
        tv_totalcosttag.setVisibility(View.GONE);
        tv_totalcost.setVisibility(View.GONE);
        tv_errormessage.setVisibility(View.GONE);
        buttonConfirmBooking.setVisibility(View.GONE);

        // get user ID using session
        sessionManager = new SessionManager(getApplicationContext());
        tv_LoginSessionUserID = findViewById(R.id.tv_LoginSessionUserID);
        tv_LoginSessionUserID.setText(sessionManager.getUserID().toString());
        // tv_LoginSessionUserID.setVisibility(View.GONE);


        // ------------- Select Time ----------------------
        ArrayAdapter<CharSequence> adapter_bookingtime = ArrayAdapter.createFromResource(getApplication(), R.array.select_bookingtime, android.R.layout.simple_spinner_item);
        adapter_bookingtime.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner_bookingtime.setAdapter(adapter_bookingtime);


        // ------------- Select No of Pax ----------------------
        ArrayAdapter<CharSequence> adapter_noofpax = ArrayAdapter.createFromResource(getApplication(), R.array.select_noofpax, android.R.layout.simple_spinner_item);
        adapter_noofpax.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner_noofpax.setAdapter(adapter_noofpax);


        // ------------- Select Date ----------------------
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        buttonSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(NewBookingsActivity1.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, onDateSetListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int DP_Year, int DP_Month, int DP_Day) {

                DP_Month = DP_Month + 1;
                String getTodayDate = DP_Day + "/" + DP_Month + "/" + DP_Year;
                buttonSelectDate.setText(getTodayDate);
            }
        };



        buttonCalculateCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                method_checkandcalculateprice();
            }
        });


        buttonConfirmBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // method_checkandcalculateprice();
            }
        });


        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                method_reset();
            }
        });


    }



    public void method_checkandcalculateprice()
    {
        if (buttonSelectDate.getText().toString().equals("- Choose Date -")) {
            Toast.makeText(NewBookingsActivity1.this, "Please Select A Date", Toast.LENGTH_LONG).show();
        }
        else if (spinner_bookingtime.getSelectedItem().toString().equals("- Choose Time -")) {
            Toast.makeText(NewBookingsActivity1.this, "Please Select A Time", Toast.LENGTH_LONG).show();
        }
        else if (spinner_noofpax.getSelectedItem().toString().equals("- Choose No -")) {
            Toast.makeText(NewBookingsActivity1.this, "Please Select A No", Toast.LENGTH_LONG).show();
        }
        else
        {
            // show total price textview
            tv_totalcosttag.setVisibility(View.VISIBLE);
            tv_totalcost.setVisibility(View.VISIBLE);
            buttonConfirmBooking.setVisibility(View.VISIBLE);


            // get No of Pax (convert String to int)
            int NoofPax = 0;
            int PriceofeachTicket = 14;
            int totalprice = 0;
            String TotalPriceinString;

            tv_totalcost.setVisibility(View.VISIBLE);
            tv_totalcost.setText(spinner_noofpax.getSelectedItem().toString());

            try
            {
                NoofPax = Integer.parseInt(spinner_noofpax.getSelectedItem().toString());
                totalprice = NoofPax * PriceofeachTicket;

                tv_totalcost.setVisibility(View.VISIBLE);
                tv_totalcost.setText("$" + totalprice);

                TotalPriceinString = "$" + totalprice;

                // set check total price to disabled
                buttonCalculateCost.setVisibility(View.GONE);

            }
            catch (Exception ex)
            {
                tv_errormessage.setVisibility(View.VISIBLE);
                tv_errormessage.setText("error" + ex);
            }

        }
    }


    public void method_reset()
    {
        buttonSelectDate.setText("- Choose Date -");
        spinner_bookingtime.setSelection(0);
        spinner_noofpax.setSelection(0);

        // Buttons to Disable when launched
        tv_totalcosttag.setVisibility(View.GONE);
        tv_totalcost.setVisibility(View.GONE);
        tv_errormessage.setVisibility(View.GONE);
        buttonConfirmBooking.setVisibility(View.GONE);
        buttonCalculateCost.setVisibility(View.VISIBLE);
        tv_errormessage.setVisibility(View.GONE);
    }


    public void method_savetodb()
    {

    }





}