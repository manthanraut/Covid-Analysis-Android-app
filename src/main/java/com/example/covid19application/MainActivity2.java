package com.example.covid19application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    //UI views
    private TextView titleTv;
    private ImageButton refreshBtn;
    private BottomNavigationView navigationView;
    //
    private Fragment homeFragment;
    private Fragment statsFragment;
    private Fragment mapsFragment;
    private Fragment activeFragment;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //inint UI views
        titleTv=findViewById(R.id.titleTv);
        refreshBtn=findViewById(R.id.refreshBtn);
        navigationView=findViewById(R.id.navigationView);
        initFragments();
        //refresh button click
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeFragment.onResume();
                statsFragment.onResume();
                mapsFragment.onResume();
            }
        });
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    private void initFragments() {
        homeFragment = new HomeFragment();
        statsFragment=new StatsFragment();
        mapsFragment= new Fragment();
        fragmentManager=getSupportFragmentManager();
        activeFragment=homeFragment;
        fragmentManager.beginTransaction()
                .add(R.id.frame,homeFragment, "homeFragment")
                .commit();
        fragmentManager.beginTransaction()
                .add(R.id.frame,statsFragment, "statsFragment").hide(statsFragment).commit();
        fragmentManager.beginTransaction()
                .add(R.id.frame,mapsFragment, "mapsFragment").hide(mapsFragment).commit();

    }
    private void loadHomeFragment(){
        titleTv.setText("Home");
        fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit();
        activeFragment=homeFragment;
    }
    private void loadStatsFragment(){
        titleTv.setText("COVID19 STATS");
        fragmentManager.beginTransaction().hide(activeFragment).show(statsFragment).commit();
        activeFragment=statsFragment;
    }
    private void loadMapsFragment(){
        titleTv.setText("Analysis on Map");
        fragmentManager.beginTransaction().hide(activeFragment).show(mapsFragment).commit();
        activeFragment=mapsFragment;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //bottom
        switch(item.getItemId()){
            case R.id.nav_home:
                loadHomeFragment();
                return true;
            case R.id.nav_stats:
                loadStatsFragment();
                return true;
            case R.id.nav_map:
                loadMapsFragment();;
                return true;
        }
        return false;
    }
}