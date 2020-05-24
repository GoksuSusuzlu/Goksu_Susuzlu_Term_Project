package com.example.goksususuzlu_termproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class SelectModelActivity extends AppCompatActivity {
    public Car newCar = new Car();



    public SelectModelActivity returnThis(){
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_model);
        Toolbar toolbar = findViewById(R.id.toolbar);


        Car.currentCar = new Car();
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.select_model);


        RecyclerView carRecycler = findViewById(R.id.car_models_recycler);
        String[] models = new String[Car.cars.length];
        for (int i = 0; i < models.length; i++) {
            models[i] = Car.cars[i].getModel();
        }
        int [] modelImages = new int[Car.cars.length];
        for (int i = 0; i < modelImages.length ; i++) {
            modelImages[i] = Car.cars[i].getImageId();
        }
        ModelCardsAdapter adapter = new ModelCardsAdapter(models,modelImages);
        carRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        carRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new ModelCardsAdapter.Listener() {


            @Override
            public void onClick(int position) {
                Car.currentCar.setModel(Car.cars[position].getModel());
                Car.currentCar.setSelectedCarInteriorImageID(position);
                Intent intent = new Intent(returnThis(),SelectMotorActivity.class);
                intent.putExtra(SelectMotorActivity.CAR_MODEL,position);
                startActivity(intent);
            }
        });

    }
}
