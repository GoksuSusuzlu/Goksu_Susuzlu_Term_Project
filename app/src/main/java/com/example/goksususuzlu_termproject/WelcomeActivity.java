package com.example.goksususuzlu_termproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.welcome);
    }

    public void onViewBuildsButtonClick(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);


    }

    public void onCreateBuildButtonClick(View view) {
        Intent intent = new Intent(this,SelectModelActivity.class);
        startActivity(intent);
    }

    public void onVisitWebsiteButtonClick(View view) {
        goToUrl("https://www.audi.com.tr/tr/web/tr.html");

    }


    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
