package com.example.goksususuzlu_termproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.Toast;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BuildsDatabaseHelper helper;
    SQLiteDatabase db;
    Cursor cursor;




    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.your_builds);


        helper = new BuildsDatabaseHelper(this);
        ListView buildsList = findViewById(R.id.car_list);
        try {
            db = helper.getReadableDatabase();
            cursor = db.query("BUILD", new String[] {"_id","MODEL","MOTOR"},null,null,null,null,null);
           ArrayList<ListItem> list = new ArrayList<>();
           while(cursor.moveToNext()){
                int id = cursor.getInt(0);
                String model = cursor.getString(1);
                String motor = cursor.getString(2);
                ListItem listItem = new ListItem(id,model,motor);
                list.add(listItem);
           }

            ArrayAdapter<ListItem> adapter = new ArrayAdapter<>(
                    this,android.R.layout.simple_list_item_1,list);
            buildsList.setAdapter(adapter);

            AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this,BuildDetailsActivity.class);


                    intent.putExtra(BuildDetailsActivity.SELECTED_BUILD_ID,position + 1);
                    startActivity(intent);
                }
            };

            buildsList.setOnItemClickListener(itemClickListener);


        }catch (SQLiteException e){
            Toast.makeText(this,"Database unavailable",Toast.LENGTH_SHORT).show();
        }





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_build_car:
                Car.currentCar = null;
                Intent intent = new Intent(this, SelectModelActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
