package com.example.tiktokappdev.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tiktokappdev.DataModels.MyCatsDataModel;
import com.example.tiktokappdev.Fragments.MyCatsDetailedFragment;
import com.example.tiktokappdev.Fragments.MyCatsMasterFragment;
import com.example.tiktokappdev.R;

public class CatsActivity extends AppCompatActivity implements MyCatsMasterFragment.CatsSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catsactivity);

        ShowCatMasterFragment();
    }

    protected void ShowCatMasterFragment()
    {
        MyCatsMasterFragment newFragmentToShow = new MyCatsMasterFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_mainMyCat, newFragmentToShow).commit();
    }

    protected void ShowCatDetailFragmentOverCatMasterFragment(String selectedCatID)
    {
        MyCatsDetailedFragment newFragmentToShow = new MyCatsDetailedFragment();
        Bundle params = new Bundle();
        params.putString("CatID", selectedCatID);
        newFragmentToShow.setArguments(params);
        getSupportFragmentManager()
                .beginTransaction()
                // .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)   // animation
                .replace(R.id.frameLayout_mainMyCat, newFragmentToShow)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onCatSelected(MyCatsDataModel cats) {

        ShowCatDetailFragmentOverCatMasterFragment(cats.getCatID());

    }

}