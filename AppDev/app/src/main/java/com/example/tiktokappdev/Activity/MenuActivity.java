package com.example.tiktokappdev.Activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.tiktokappdev.Fragments.MenuMasterFragment;
import com.example.tiktokappdev.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuactivity);

        ShowMenuMasterFragment();
    }

    protected void ShowMenuMasterFragment()
    {
        MenuMasterFragment newFragmentToShow = new MenuMasterFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_mainMyCat, newFragmentToShow).commit();
    }
}
