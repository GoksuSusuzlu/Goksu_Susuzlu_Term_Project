package com.example.goksususuzlu_termproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class ModifyCarActivity extends AppCompatActivity {

    BuildsDatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_car);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Modify Car");

        SectionsPagerAdapter pagerAdapter =
                new SectionsPagerAdapter(getSupportFragmentManager(),1);
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);


    }

    public void onDoneButtonClick(View view) {

        helper = new BuildsDatabaseHelper(getApplicationContext());

        if (!Car.currentCar.exteriorComplete()){
            Toast.makeText(this,"Configure exterior first",Toast.LENGTH_SHORT).show();
        }

        else if (!Car.currentCar.interiorComplete()){
            Toast.makeText(this,"Configure interior first",Toast.LENGTH_SHORT).show();

        }
        else {


            try {
                SQLiteDatabase db = helper.getWritableDatabase();
                helper.addBuild(db, Car.currentCar);
                Toast.makeText(this, R.string.build_inserted, Toast.LENGTH_SHORT).show();
            } catch (SQLiteException e) {
                Toast.makeText(this, R.string.build_failed, Toast.LENGTH_SHORT).show();

            }
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        }



    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter{


        public SectionsPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return getResources().getText(R.string.exterior_tab);
                case 1:
                    return getResources().getText(R.string.interior_tab);
                case 2:
                    return getResources().getText(R.string.hardware_tab);
            }
            return null;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new ModifyExteriorFragment();

                case 1:
                    return new ModifyInteriorFragment();

                case 2:
                    return new ModifyHardwareFragment();
            }

            return null;

        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
