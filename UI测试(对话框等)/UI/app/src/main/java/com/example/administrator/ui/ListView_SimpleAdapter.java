package com.example.administrator.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListView_SimpleAdapter extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view__simple_adapter);

        SimpleAdapter adapter=new SimpleAdapter(this,get_data(),R.layout.simple_test,new String[]{"title","img"},new int[]{R.id.title,R.id.img});
        listView= (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
    private List<Map<String,Object>> get_data(){
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("title","标题1");
        map.put("img",R.mipmap.ic_launcher);
        list.add(map);

        map=new HashMap<>();
        map.put("title","标题2");
        map.put("img",R.mipmap.ic_launcher);
        list.add(map);

        map=new HashMap<>();
        map.put("title","标题3");
        map.put("img",R.mipmap.ic_launcher);
        list.add(map);
        return list;
    }
}
