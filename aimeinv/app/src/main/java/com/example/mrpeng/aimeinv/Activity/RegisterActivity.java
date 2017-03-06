package com.example.mrpeng.aimeinv.Activity;

import android.app.ProgressDialog;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrpeng.aimeinv.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {

   public static String Name="Name";
    public static String PassWord="PassWord";
    public static String Button="Button";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        InitView();
    }

    private void InitView() {
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText ConfirmPassword = (EditText) findViewById(R.id.ConfirmPassword);
        Button register = (Button) findViewById(R.id.register);

        ViewCompat.setTransitionName(name,Name);
        ViewCompat.setTransitionName(password,PassWord);
        ViewCompat.setTransitionName(register,Button);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(name.getText().toString().trim()) && !TextUtils.isEmpty(password.getText().toString().trim()) && !TextUtils.isEmpty(ConfirmPassword.getText().toString().trim())) {

                    if (password.getText().toString().trim().equals(ConfirmPassword.getText().toString().trim())) {
                        final ProgressDialog dialog=new ProgressDialog(RegisterActivity.this);
                        dialog.show();
                        BmobUser bu = new BmobUser();
                        bu.setUsername(name.getText().toString().trim());
                        bu.setPassword(password.getText().toString().trim());

                        //注意：不能用save方法进行注册
                        bu.signUp(new SaveListener<BmobUser>() {
                            @Override
                            public void done(BmobUser s, BmobException e) {
                                dialog.cancel();
                                if (e == null) {
                                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                                    finish();
                                } else {
                                    Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                    } else {
                        Toast.makeText(RegisterActivity.this, "输入的密码不一致", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(RegisterActivity.this, "请完整填写", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
