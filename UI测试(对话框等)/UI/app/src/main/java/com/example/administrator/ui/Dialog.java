package com.example.administrator.ui;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Dialog extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.first).setOnClickListener(this);
        findViewById(R.id.second).setOnClickListener(this);
        findViewById(R.id.third).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.first:
                first(v);
                break;
            case R.id.second:
                second(v);
                break;
            case R.id.third:
                third(v);
                break;
            case R.id.four:
                four(v);
                break;
        }
    }

    private void four(View v) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(R.string.title);
         final String[] item=getResources().getStringArray(R.array.items);
        builder.setMultiChoiceItems(R.array.items, new boolean[]{true, false, true}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
               Toast.makeText(getApplication(),item[which]+isChecked,Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void third(View v) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(R.string.title);
        builder.setSingleChoiceItems(R.array.items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              Toast.makeText(getApplication(),"success",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void second(View v) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(R.string.title);
        builder.setItems(R.array.items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                switch (i){
                    case 0:
                     Toast.makeText(getApplication(),"test_one",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplication(),"test_second",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplication(),"test_third",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void first(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(R.string.title);
        builder.setMessage(R.string.message);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),R.string.ok,Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),R.string.cancel,Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
