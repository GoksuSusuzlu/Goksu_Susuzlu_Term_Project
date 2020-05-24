package com.example.goksususuzlu_termproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BuildsDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "builds";
    private static final int DB_VERSION = 1;

    public BuildsDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE BUILD(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "MODEL TEXT," +
                "MOTOR TEXT," +
                "BODYCOLOR TEXT," +
                "RIMS TEXT," +
                "HEADLIGHTS TEXT," +
                "SEATS TEXT," +
                "SEAT_FURNISHING TEXT," +
                "STEERING_WHEEL TEXT," +
                "DECORATIVE_INSERTS TEXT," +
                "SMARTPHONE_INTERFACE NUMERIC," +
                "VIRTUAL_COCKPIT NUMERIC," +
                "PARK_ASSISTANT NUMERIC," +
                "HILL_START_ASSIST NUMERIC)" );

    }
    public void addBuild(SQLiteDatabase db, Car car){
        ContentValues values = new ContentValues();
        values.put("MODEL", car.getModel());
        values.put("MOTOR",car.getMotor());
        values.put("BODYCOLOR", car.getBodyColor());
        values.put("RIMS",car.getRims().getName());
        values.put("HEADLIGHTS",car.getHeadlights().getName());
        values.put("SEATS",car.getSeat().getSeatType());
        values.put("SEAT_FURNISHING",car.getSeat().getFurnishing().getName());
        values.put("STEERING_WHEEL",car.getSteeringWheel().getWheelType());
        values.put("DECORATIVE_INSERTS",car.getDecorativeElements().getName());
        values.put("SMARTPHONE_INTERFACE",car.isSmartphoneInterface());
        values.put("VIRTUAL_COCKPIT",car.isVirtualCockpit());
        values.put("PARK_ASSISTANT",car.isParkAssistant());
        values.put("HILL_START_ASSIST",car.isHillStartAssist());
        db.insert("BUILD",null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }







}
