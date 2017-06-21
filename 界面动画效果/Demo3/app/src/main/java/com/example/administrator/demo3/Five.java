package com.example.administrator.demo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Five extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        Toolbar toolbar= (Toolbar) findViewById(R.id.five_toolbar);
        setSupportActionBar(toolbar);
    }
}
