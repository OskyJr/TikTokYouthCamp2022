package com.example.tiktokappdev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tiktokappdev.Activity.DashboardActivity;
import com.example.tiktokappdev.DataManagers.UserDetailsDataManager;
import com.example.tiktokappdev.DataModels.UserDetailsDataModel;
import com.example.tiktokappdev.Network.Methods;
import com.example.tiktokappdev.Network.Model;
import com.example.tiktokappdev.Network.RetrofitClient;
import com.example.tiktokappdev.SessionManager.SessionManager;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    Button btnLogin;
    EditText et_username, et_password;
    TextView tv_LoginStatus;
    UserDetailsDataManager UDDM;
    SessionManager sessionManager;
    //TODO: testing for network api
    private static final String TAG = "MainActivity";
    private Button getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect Declaired Variables
        btnLogin = findViewById(R.id.btn_login);
        et_username = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        tv_LoginStatus = findViewById(R.id.tv_LoginStatus);


        // initialize DataManager
        UDDM = new UserDetailsDataManager();
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
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userDetailsDataModel[0] = UDDM.GetLoginStatus(et_username.getText().toString(), et_password.getText().toString());

                if (userDetailsDataModel[0] != null)
                {
                    tv_LoginStatus.setText("Login Successful!");

                    // get UserID
                    String UserID = userDetailsDataModel[0].getUserID().toString();

                    // Store Login in session
                    sessionManager.setLogin(true);
                    // store username in session
                    sessionManager.setUserID(UserID);

                    // Go to Dashboard Activity (intent)
                    // openDashboardActivity();
                    Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(i);

                }
                else
                {
                    tv_LoginStatus.setText("Login Failed! Please Try Again!");
                }

            }
        });

        getData = findViewById(R.id.getData);
        getData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
                Call<Model> call = methods.getAllData();

                call.enqueue(new Callback<Model>() {
                    //@Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Log.e(TAG, "onResponse: code: " +response.code() );

                        ArrayList<Model.data> drinksData = response.body().getDrinks();
                        ArrayList<Model.data> foodData = response.body().getFood();

                        for (Model.data data1 : drinksData) {
                            Log.e(TAG, "drink: " + data1.getId() + data1.getName() + data1.getPrice());
                        }
                        for (Model.data data2 : drinksData) {
                            Log.e(TAG, "food: " + data2.getId() + data2.getName() + data2.getPrice());
                        }
                    }

                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.e(TAG, "onFailure: "+t.getMessage());
                    }

                });
            }
        });

    } // end of onCreate()


    public void openDashboardActivity()
    {
        Intent intent = new Intent( MainActivity.this, DashboardActivity.class);
        startActivity(intent);
    }

}