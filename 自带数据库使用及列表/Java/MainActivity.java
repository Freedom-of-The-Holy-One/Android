package com.example.administrator.dc;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup mRadioGroup;
    private RadioButton main_rb;
    private RadioButton Humanities_rb;
    private RadioButton history_rb;
    private RadioButton natural_rb;
    private RecyclerView main_rv;
    private RecyclerView chose_rv;

    private DbOperator mDbOperator;

    private List<SightInfo> sign_data;
    private List<String> sign_name;
    private List<Double> lon;
    private List<Double> lat;
    private MainAdapter mMainAdapter;

    private boolean IsMain=true;
    private String title_text;

    private LinearLayout liner_item;

    private List<String> chose_Sight=new ArrayList<>();
    //选择景点的经纬度信息
    private List<Double> chose_lon=new ArrayList<>();
    private List<Double> chose_lat=new ArrayList<>();

    private Button clear_data;

    private InsertData mInsertData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);

        setContentView(R.layout.activity_main);

        SharedPreferences share = getSharedPreferences("IsInsert", MODE_PRIVATE);
        boolean se=share.getBoolean("Insert",false);
        if(!se) {
            mInsertData=new InsertData();
            mInsertData.insert(getApplicationContext());
            SharedPreferences share1 = getSharedPreferences("IsInsert", MODE_PRIVATE);
            SharedPreferences.Editor edit = share1.edit();
            edit.putBoolean("Insert",true);
            edit.apply();
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        mRadioGroup.setOnCheckedChangeListener(this);

        main_rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mMainAdapter=new MainAdapter(Get_All_Text());
        main_rv.setAdapter(mMainAdapter);

        chose_rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ChoseAdapter adapter=new ChoseAdapter(chose_Sight);
        chose_rv.setAdapter(adapter);

        clear_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chose_Sight.clear();
                chose_rv.setAdapter(new ChoseAdapter(chose_Sight));
                chose_lon.clear();
                chose_lat.clear();
            }
        });

        final Handler handler=new Handler();
        Runnable runnable=new Runnable(){
            @Override
            public void run() {
                mMainAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if(IsMain){
                            Log.e("Item点击事件", Get_All_Text().get(position));
                            chose_Sight.add(Get_All_Text().get(position));
                            chose_lon.add(lon.get(position));
                            chose_lat.add(lon.get(position));
                            Log.e("size", String.valueOf(chose_Sight.size()));
                            chose_rv.setAdapter(new ChoseAdapter(chose_Sight));
                        }else{
                            Log.e("Item点击事件", Get_Text(title_text).get(position));
                            chose_Sight.add(Get_Text(title_text).get(position));
                            chose_lon.add(lon.get(position));
                            chose_lat.add(lon.get(position));
                            Log.e("size2", String.valueOf(chose_Sight.size()));
                            chose_rv.setAdapter(new ChoseAdapter(chose_Sight));
                        }
                    }
                });
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    private void init(){
        mRadioGroup= (RadioGroup) findViewById(R.id.rg);
        main_rb= (RadioButton) findViewById(R.id.main_rb);
        Humanities_rb= (RadioButton) findViewById(R.id.Humanities_rb);
        history_rb= (RadioButton) findViewById(R.id.history_rb);
        natural_rb= (RadioButton) findViewById(R.id.natural_rb);
        main_rv= (RecyclerView) findViewById(R.id.main_rv);
        chose_rv= (RecyclerView) findViewById(R.id.chose_rv);
        clear_data= (Button) findViewById(R.id.clear_data);
        liner_item= (LinearLayout) findViewById(R.id.item_liner);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.main_rb:
                IsMain=true;
                mMainAdapter=new MainAdapter(Get_All_Text());
                main_rv.setAdapter(mMainAdapter);
                break;
            case R.id.Humanities_rb:
                IsMain=false;
                title_text = Humanities_rb.getText().toString();
                mMainAdapter=new MainAdapter(Get_Text(Humanities_rb.getText().toString()));
                main_rv.setAdapter(mMainAdapter);
                break;
            case R.id.history_rb:
                IsMain=false;
                title_text = history_rb.getText().toString();
                mMainAdapter=new MainAdapter(Get_Text(history_rb.getText().toString()));
                main_rv.setAdapter(mMainAdapter);
                break;
            case R.id.natural_rb:
                IsMain=false;
                title_text = natural_rb.getText().toString();
                mMainAdapter=new MainAdapter(Get_Text(natural_rb.getText().toString()));
                main_rv.setAdapter(mMainAdapter);
                break;
        }
    }

    private List<String> Get_All_Text(){
        mDbOperator=new DbOperator(getApplicationContext());
        sign_data=mDbOperator.Query_All();
        sign_name=new ArrayList<>();
        lon=new ArrayList<>();
        lat=new ArrayList<>();
        for(int i=0;i<sign_data.size();i++){
            sign_name.add(sign_data.get(i).getSight_name());
            lon.add(sign_data.get(i).getLon());
            lat.add(sign_data.get(i).getLat());
        }
        return sign_name;
    }

    private List<String> Get_Text(String string){
        mDbOperator=new DbOperator(getApplicationContext());
        sign_data=mDbOperator.Query_Type(string);
        sign_name=new ArrayList<>();
        lon=new ArrayList<>();
        lat=new ArrayList<>();
        for(int i=0;i<sign_data.size();i++){
            sign_name.add(sign_data.get(i).getSight_name());
            lon.add(sign_data.get(i).getLon());
            lat.add(sign_data.get(i).getLat());
        }
        return sign_name;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
