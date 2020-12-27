package com.example.bathangban;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home_Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__admin);
        BottomNavigationView bottomNav = findViewById(R.id.Toolbar_admin);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_admin,new Home_Fragment_admin()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectFragment = null;
                    switch (item.getItemId()){
                        case R.id.nav_home_admin:
                            selectFragment = new Home_Fragment_admin();
                            break;
                        case R.id.nav_infor_admin:
                            selectFragment = new HoSo_fragment_admin();
                            break;
                        case R.id.nav_chucnang_admin:
                            selectFragment = new ChucNang_Fragment_admin();
                            break;
                        case R.id.nav_search_admin:
                            selectFragment = new TiemKiem_Fragment_admin();
                            break;
                        default:
                            return false;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_admin,selectFragment).commit();
                    return true;

                }
            };
}