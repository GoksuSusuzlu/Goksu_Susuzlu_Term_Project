package com.example.goksususuzlu_termproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BuildDetailsActivity extends AppCompatActivity {

    BuildsDatabaseHelper helper;
    public static final String SELECTED_BUILD_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.build_details);

        helper = new BuildsDatabaseHelper(this);

        Intent intent = getIntent();

        int itemID = intent.getExtras().getInt(SELECTED_BUILD_ID);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("BUILD",new String[]{"_id","MODEL","MOTOR","BODYCOLOR","RIMS","HEADLIGHTS","SEATS","SEAT_FURNISHING","STEERING_WHEEL","DECORATIVE_INSERTS"},"_id = ?",new String[]{Integer.toString(itemID)},null,null,null);
        setTexts(cursor);
        }





    private void setTexts(Cursor cursor){
        TextView motor = findViewById(R.id.build_motor);
        TextView bodycolor = findViewById(R.id.build_bodycolor);
        TextView rims = findViewById(R.id.build_rims);
        TextView headlights = findViewById(R.id.build_headlights);
        TextView seats = findViewById(R.id.build_seats);
        TextView seatFurnishing = findViewById(R.id.build_seat_furnishing);
        TextView steeringWheel = findViewById(R.id.build_steering_wheel);
        TextView decorativeInserts = findViewById(R.id.build_decorative_inserts);

        ImageView carImage = findViewById(R.id.car_image);


        cursor.moveToNext();

        if (cursor.getString(1).equals("A3 Sedan")){
            carImage.setImageResource(R.drawable.a3);
        }
        if (cursor.getString(1).equals("A1 Sportback")){
            carImage.setImageResource(R.drawable.a1);
        }
        if (cursor.getString(1).equals("A4 Sedan")){
            carImage.setImageResource(R.drawable.a4);
        }
        if (cursor.getString(1).equals("A5 Sportback")){
            carImage.setImageResource(R.drawable.a5);
        }

        motor.setText(getString(R.string.build_motor_text) + cursor.getString(2));
        bodycolor.setText(getString(R.string.bodycolor) + cursor.getString(3));
        rims.setText(getString(R.string.rims)  + cursor.getString(4));
        headlights.setText(getString(R.string.headlights_display) + cursor.getString(5));
        seats.setText(getString(R.string.seat_display) + cursor.getString(6));
        seatFurnishing.setText(getString(R.string.seat_furnishing_display) + cursor.getString(7));
        steeringWheel.setText(getString(R.string.steering_wheel_display) + cursor.getString(8));
        decorativeInserts.setText(getString(R.string.decorative_inserts_display) + cursor.getString(9));
    }




    }

