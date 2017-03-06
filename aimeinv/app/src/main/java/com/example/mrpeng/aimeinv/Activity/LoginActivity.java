package com.example.mrpeng.aimeinv.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mrpeng.aimeinv.Baen.UserUtils;
import com.example.mrpeng.aimeinv.R;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends BaseActivity {

    private EditText name, password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        TextView register= (TextView) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                //元素交互
                ActivityOptionsCompat compat = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(LoginActivity.this,Pair.create((View)name,RegisterActivity.Name),
                                Pair.create((View)password,RegisterActivity.PassWord),
                                Pair.create((View)login,RegisterActivity.Button));
                ActivityCompat.startActivity(LoginActivity.this, intent, compat.toBundle());


//                startActivity(intent);

            }
        });
    }

    public void Login(View v) {
        final ProgressDialog dialog=new ProgressDialog(LoginActivity.this);
        dialog.show();
        String NAME = name.getText().toString();
        String PASSWORD = password.getText().toString();
        BmobUser login = new BmobUser();
        login.setUsername(NAME);
        login.setPassword(PASSWORD);
        login.login(new SaveListener<BmobUser>() {
            @Override
            public void done(BmobUser user, BmobException e) {
                dialog.cancel();
                if (e == null) {
                    Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_LONG).show();
                    BmobUser users = BmobUser.getCurrentUser();   //通过获取登录成功后的本地用户信息
                    UserUtils.setUserBase(user);
                    finish();

                    //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                } else {
                    Toast.makeText(getApplicationContext(), "请检查你的账号密码", Toast.LENGTH_LONG).show();
                }

            }
        });




    }

}
