package com.example.responsi_123180122.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.responsi_123180122.view.fragment.FragmentKasusHarian;
import com.example.responsi_123180122.view.fragment.FragmentRujukan;
import com.example.responsi_123180122.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView navbar;
    private Fragment fragment = new FragmentKasusHarian() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        navbar = findViewById(R.id.bottom_nav);
        navbar.setOnNavigationItemSelectedListener(this);

        loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_fragmentcontainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_botnav_kasus:
                fragment = new FragmentKasusHarian();
                break;

            case R.id.menu_botnav_rujukan:
                fragment = new FragmentRujukan();
        }
        return loadFragment(fragment);
    }

}