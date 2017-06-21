package com.example.administrator.ui;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class Search extends AppCompatActivity {

    private EditText et_search;
    private TextView tv_vip;
    private TextView tv_clear;
    private RecordSQLiteOpenHelper sqLiteOpenHelper=new RecordSQLiteOpenHelper(this);
    private SQLiteDatabase db;
    private BaseAdapter adapter;
    private MyListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search);

        et_search= (EditText) findViewById(R.id.search);
        tv_vip= (TextView) findViewById(R.id.tv_tip);
        tv_clear= (TextView) findViewById(R.id.tv_clear);
        listView= (MyListView) findViewById(R.id.listView);

        Drawable drawableRes=getResources().getDrawable(R.drawable.search);
        drawableRes.setBounds(0,0,60,60);
        et_search.setCompoundDrawables(drawableRes,null,null,null);

        tv_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteData();
                QueryData("");
            }
        });

        et_search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                            getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                   boolean hasData=hasData(et_search.getText().toString().trim());
                    if(!hasData){
                       InsertData(et_search.getText().toString().trim());
                       QueryData("");
                   }
                    Toast.makeText(getApplication(), "查询到的结果为"+et_search.getText().toString().trim()+"success", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().length() == 0) {
                    tv_vip.setText("搜索历史");
                } else {
                    tv_vip.setText("搜索结果");
                }
                String tempName = et_search.getText().toString();
                QueryData(tempName);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView= (TextView)view.findViewById(android.R.id.text1);
                String name = textView.getText().toString();
                et_search.setText(name);
                Toast.makeText(getApplication(), name, Toast.LENGTH_SHORT).show();
            }
        });
        Date date=new Date();
        long time=date.getTime();
        InsertData("Leo" + time);

        QueryData("");
    }

    private void InsertData(String trim) {
        db=sqLiteOpenHelper.getWritableDatabase();
        db.execSQL("insert into records(name) values('" + trim + "')");
        db.close();
    }

    private boolean hasData(String trim) {
        Cursor cursor=sqLiteOpenHelper.getReadableDatabase().rawQuery( "select id as _id,name from records where name =?", new String[]{trim});
        return cursor.moveToNext();
    }

    private void QueryData(String tempName) {
        Cursor cursor =sqLiteOpenHelper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);
        // 创建adapter适配器对象
        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[] { "name" },
                new int[] { android.R.id.text1 }, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        // 设置适配器
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void DeleteData() {
        db=sqLiteOpenHelper.getWritableDatabase();
        db.execSQL("delete from records");
        db.close();
    }
}
