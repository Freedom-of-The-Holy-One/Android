package com.example.administrator.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Selector extends AppCompatActivity {

    private ImageButton button;
    private boolean active=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        button= (ImageButton) findViewById(R.id.select);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(active){
                    button.setBackgroundResource(R.drawable.btn_nav_drag_down_pressed);
                    active=false;
                }else {
                    button.setBackgroundResource(R.drawable.btn_nav_drag_down_normal);
                    active=true;
                }
            }
        });
    }
}
