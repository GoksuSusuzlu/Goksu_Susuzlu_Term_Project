package com.example.goksususuzlu_termproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

public class SelectMotorActivity extends AppCompatActivity implements SelectMotorFragment.Listener{
    public static final String CAR_MODEL = "model";

    public Car newCar = new Car();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_motor);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.select_motor);

        SelectMotorFragment fragment = (SelectMotorFragment) getSupportFragmentManager().findFragmentById(R.id.motorFragment);
        newCar = fragment.getNewCar();

    }

    @Override
    public void itemClicked(long id) {
        Car.currentCar.setMotor(newCar.getSelectedCarMotors()[(int) id]);
        Intent intent = new Intent(this,ModifyCarActivity.class);
        startActivity(intent);
    }
}
