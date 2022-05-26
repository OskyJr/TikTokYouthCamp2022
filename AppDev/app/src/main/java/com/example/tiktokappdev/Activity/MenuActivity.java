package com.example.tiktokappdev.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tiktokappdev.DataModels.MyCatsDataModel;
import com.example.tiktokappdev.Fragments.MyCatsDetailedFragment;
import com.example.tiktokappdev.Fragments.MyCatsMasterFragment;
import com.example.tiktokappdev.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuactivity);
    }
}
