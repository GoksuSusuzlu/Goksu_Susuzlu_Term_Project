package com.example.goksususuzlu_termproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class SelectColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_color);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.select_color);
    }

    public void onDoneButtonClick(View view) {
        Spinner sp = findViewById(R.id.color_select_spinner);
        Car.currentCar.setBodyColor(sp.getSelectedItem().toString());

        Intent intent = new Intent(this,ModifyCarActivity.class);
        startActivity(intent);
    }
}
