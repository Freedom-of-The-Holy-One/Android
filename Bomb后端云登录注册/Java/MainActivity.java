package com.example.administrator.bmob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     EditText user_name;
     EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bmob.initialize(this,Set.Application_ID);

        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.sign).setOnClickListener(this);
        user_name= (EditText) findViewById(R.id.user_name);
        password= (EditText) findViewById(R.id.password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                BmobUser data=new BmobUser();
                data.setUsername(user_name.getText().toString().trim());
                data.setPassword(password.getText().toString().trim());
                data.login(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if(e==null){
                            Toast.makeText(getApplication(),"登录成功！",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplication(),"登录失败！"+e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.sign:
                Intent intent=new Intent(MainActivity.this,Sign.class);
                startActivity(intent);
                break;
        }
    }

}
