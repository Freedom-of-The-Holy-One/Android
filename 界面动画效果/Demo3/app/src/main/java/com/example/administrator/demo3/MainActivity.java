package com.example.administrator.demo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.first).setOnClickListener(this);
        findViewById(R.id.third).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.first:
                Intent intent=new Intent(MainActivity.this,First.class);
                startActivity(intent);
                break;
            case R.id.third:
                Intent intent3=new Intent(MainActivity.this,Third.class);
                startActivity(intent3);
                break;
            case R.id.four:
                Intent intent4=new Intent(MainActivity.this,Four.class);
                startActivity(intent4);
                break;
            case R.id.five:
                Intent intent5=new Intent(MainActivity.this,Five.class);
                startActivity(intent5);
                break;
            case R.id.six:
                Intent intent6=new Intent(MainActivity.this,Six.class);
                startActivity(intent6);
                break;
        }
    }
}
