package com.example.tiktokappdev.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tiktokappdev.R;

public class AppointmentActivity extends AppCompatActivity {

    private Button btn_bookaseat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

        // function for booking a seat
        btn_bookaseat = findViewById(R.id.btn_bookaseat);
        btn_bookaseat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                startActivity(new Intent(getApplicationContext(), NewBookingsActivity1.class));
            }
        });
    }
}