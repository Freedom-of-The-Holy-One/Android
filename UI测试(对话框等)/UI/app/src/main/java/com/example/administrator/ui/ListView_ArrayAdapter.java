package com.example.administrator.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListView_ArrayAdapter extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view__array_adapter);

        listView= (ListView) findViewById(R.id.list_view_one);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout
        .simple_list_item_1,get_Data()));
    }
    private List<String> get_Data(){
        List<String> data=new ArrayList<String>();
        data.add("测试数据一");
        data.add("测试数据二");
        data.add("测试数据三");
        data.add("测试数据四");
        return data;
    }
}
