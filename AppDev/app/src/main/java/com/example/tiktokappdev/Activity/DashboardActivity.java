package com.example.tiktokappdev.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tiktokappdev.Activity.CatsActivity;
import com.example.tiktokappdev.R;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener  {

    private CardView cardview_ourcats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardactivity);

        cardview_ourcats = findViewById(R.id.cardview_ourcats);
        cardview_ourcats.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.cardview_ourcats:
                startActivity(new Intent(getApplicationContext(), CatsActivity.class));
                break;

        }


    }
}