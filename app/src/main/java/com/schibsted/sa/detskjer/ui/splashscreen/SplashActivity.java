package com.schibsted.sa.detskjer.ui.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.schibsted.sa.detskjer.ui.eventsList.EventsListActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, EventsListActivity.class);
        startActivity(intent);
        finish();
    }
}
