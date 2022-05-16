package com.example.tiktokappdev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView cardview_ourcats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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