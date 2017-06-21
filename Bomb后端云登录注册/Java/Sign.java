package com.example.administrator.bmob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class Sign extends AppCompatActivity implements View.OnClickListener {

    private EditText user_name;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        findViewById(R.id.sign).setOnClickListener(this);
        findViewById(R.id.cancel).setOnClickListener(this);
        user_name= (EditText) findViewById(R.id.user_name);
        password= (EditText) findViewById(R.id.password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign:
                BmobUser ps = new BmobUser();
                String name=user_name.getText().toString();
                String pass=password.getText().toString();
                ps.setUsername(name);
                ps.setPassword(pass);
                ps.signUp(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser b, BmobException e) {
                        if(e==null){
                            Toast.makeText(getApplication(),"注册成功！",Toast.LENGTH_SHORT).show();
                        }else{
                            Log.i("o",e.getMessage());
                            Toast.makeText(getApplication(),"注册失败！"+e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.cancel:
                Intent intent = new Intent(Sign.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
