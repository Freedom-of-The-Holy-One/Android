package com.example.administrator.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.demo1).setOnClickListener(this);
        findViewById(R.id.demo2).setOnClickListener(this);
        findViewById(R.id.demo3).setOnClickListener(this);
        findViewById(R.id.demo4).setOnClickListener(this);
        findViewById(R.id.demo5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.demo1:
                Intent intent=new Intent(MainActivity.this,Dialog.class);
                startActivity(intent);
            break;
            case R.id.demo2:
                Intent intent2=new Intent(MainActivity.this,Adapter.class);
                startActivity(intent2);
                break;
            case R.id.demo3:
                Intent intent3=new Intent(MainActivity.this,Selector.class);
                startActivity(intent3);
                break;
            case R.id.demo4:
                Intent intent4=new Intent(MainActivity.this,Search.class);
                startActivity(intent4);
                break;
            case R.id.demo5:
                Intent intent5=new Intent(MainActivity.this,Draw.class);
                startActivity(intent5);
                break;
        }
    }
}
