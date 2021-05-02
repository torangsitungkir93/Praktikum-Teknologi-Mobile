package com.example.tugas_4_torangtositungkir_123180122;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContentActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        navbar = findViewById(R.id.bottom_nav);
        navbar.setOnNavigationItemSelectedListener(this);

        loadFragment(new Fragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.ic_home:
                fragment = new com.example.tugas_4_torangtositungkir_123180122.HomeFragment();
                break;

            case R.id.ic_profile:
                fragment = new com.example.tugas_4_torangtositungkir_123180122.ProfileFragment();
        }
        return loadFragment(fragment);
    }

    public boolean loadFragment (Fragment fragment){

        if(fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}