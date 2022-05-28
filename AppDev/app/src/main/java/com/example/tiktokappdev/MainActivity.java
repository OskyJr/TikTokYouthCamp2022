package com.example.tiktokappdev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tiktokappdev.Activity.DashboardActivity;
import com.example.tiktokappdev.DataManagers.UserDetailsDataManager;
import com.example.tiktokappdev.DataModels.UserDetailsDataModel;
import com.example.tiktokappdev.SessionManager.SessionManager;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText et_username, et_password;
    TextView tv_LoginStatus;
    UserDetailsDataManager userDetailsDataManager;
    SessionManager sessionManager;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect Declared Variables
        btnLogin = findViewById(R.id.btn_login);
        et_username = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        tv_LoginStatus = findViewById(R.id.tv_LoginStatus);


        // initialize DataManager
        userDetailsDataManager = new UserDetailsDataManager();
        // initiate session
        sessionManager = new SessionManager(getApplicationContext());
        // DataModel
        final UserDetailsDataModel[] userDetailsDataModel = {null};


        // It will stay login once you login 1 time
        if (sessionManager.getLogin())
        {
            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));   // shortcut for intent
        }


        // Login Button OnClick Functions
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(v -> {

            userDetailsDataModel[0] = userDetailsDataManager.GetLoginStatus(et_username.getText().toString(), et_password.getText().toString());

            if (userDetailsDataModel[0] != null)
            {
                tv_LoginStatus.setText("Login Successful!");

                // get UserID
                String UserID = userDetailsDataModel[0].getUserID();

                // Store Login in session
                sessionManager.setLogin(true);
                // store username in session
                sessionManager.setUserID(UserID);

                // Go to Dashboard Activity (intent)
                Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(i);

            }
            else
            {
                tv_LoginStatus.setText("Login Failed! Please Try Again!");
            }

        });
    } // end of onCreate()
}