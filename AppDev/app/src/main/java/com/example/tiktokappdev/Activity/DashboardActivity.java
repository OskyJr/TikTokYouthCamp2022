package com.example.tiktokappdev.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tiktokappdev.Activity.CatsActivity;
import com.example.tiktokappdev.DataManagers.UserDetailsDataManager;
import com.example.tiktokappdev.DataModels.UserDetailsDataModel;
import com.example.tiktokappdev.MainActivity;
import com.example.tiktokappdev.R;
import com.example.tiktokappdev.SessionManager.SessionManager;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener  {

    private CardView cardview_ourcats;
    private CardView cardview_menu;
    private CardView cardview_myreservation;
    private CardView cardview_aboutandcontactus;

    private Button btn_logout;

    String UserName;
    String UserEmail;
    UserDetailsDataManager UDDM;
    SessionManager sessionManager;
    private TextView tv_LoginSessionUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardactivity);


        // get user ID using session
        sessionManager = new SessionManager(getApplicationContext());
        tv_LoginSessionUserID = findViewById(R.id.tv_LoginSessionUserID);
        tv_LoginSessionUserID.setText(sessionManager.getUserID().toString());
        tv_LoginSessionUserID.setVisibility(View.GONE);
//        UDDM = new UserDetailsDataManager();
//        final UserDetailsDataModel[] userDetailsDataModel = {null};
//        userDetailsDataModel[0] = UDDM.GetUserProfileDetails(sessionManager.getUserID().toString());
//        UserName = userDetailsDataModel[0].getName().toString();
//        UserEmail = userDetailsDataModel[0].getEmail().toString();




        btn_logout = findViewById(R.id.btn_logout);

        cardview_ourcats = findViewById(R.id.cardview_ourcats);
        cardview_ourcats.setOnClickListener(this);

        cardview_menu = findViewById(R.id.cardview_menu);
        cardview_menu.setOnClickListener(this);

        cardview_myreservation = findViewById(R.id.cardview_myreservation);
        cardview_myreservation.setOnClickListener(this);

        cardview_aboutandcontactus = findViewById(R.id.cardview_aboutandcontactus);
        cardview_aboutandcontactus.setOnClickListener(this);


        btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                sessionManager.setLogin(false);
                sessionManager.setUserID("");
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.cardview_ourcats:
                startActivity(new Intent(getApplicationContext(), CatsActivity.class));
                break;
            case R.id.cardview_menu:
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                break;

            case R.id.cardview_myreservation:
                startActivity(new Intent(getApplicationContext(), AppointmentActivity.class));
                break;

            case R.id.cardview_aboutandcontactus:
                startActivity(new Intent(getApplicationContext(), ContactUsActivity.class));
                break;

        }


    }
}