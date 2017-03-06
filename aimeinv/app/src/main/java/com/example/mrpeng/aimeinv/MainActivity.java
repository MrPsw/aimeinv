package com.example.mrpeng.aimeinv;



import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;

import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;


import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;


import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mrpeng.aimeinv.Activity.BaseActivity;
import com.example.mrpeng.aimeinv.Activity.LoginActivity;
import com.example.mrpeng.aimeinv.Baen.SyBaen;
import com.example.mrpeng.aimeinv.Baen.UserUtils;
import com.example.mrpeng.aimeinv.Fragment.FreshlyPicture;
import com.example.mrpeng.aimeinv.Fragment.HomeFragment;

import com.example.mrpeng.aimeinv.Fragment.SexyFragment;
import com.example.mrpeng.aimeinv.View.WaveView3;
import com.pgyersdk.javabean.AppBean;
import com.pgyersdk.update.PgyUpdateManager;
import com.pgyersdk.update.UpdateManagerListener;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.pgyersdk.update.UpdateManagerListener.getAppBeanFromString;

public class MainActivity extends BaseActivity implements View.OnClickListener
{
    List IMAGES= new ArrayList();
    List TITLE=new ArrayList();
    private Map<String, String> map;
    private Banner banner;
    private RecyclerView recyclerView;
    private DrawerLayout mDrawerLayout;
    private Fragment fragment;
    private FragmentManager fm;
    private TextView UserName;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main2);
        fm=super.getSupportFragmentManager();
        PgyUpdateManager.register(this);

        PgyUpdateManager.register(MainActivity.this,
                new UpdateManagerListener() {

                    @Override
                    public void onUpdateAvailable(final String result) {

                        // 将新版本信息封装到AppBean中
                        final AppBean appBean = getAppBeanFromString(result);
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("更新")
                                .setMessage("")
                                .setNegativeButton(
                                        "确定",
                                        new DialogInterface.OnClickListener() {

                                            @Override
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                                                startDownloadTask(
                                                        MainActivity.this,
                                                        appBean.getDownloadURL());
                                            }
                                        }).show();
                    }

                    @Override
                    public void onNoUpdateAvailable() {
                    }
                });


        initView();
        // 开启一个子线程，进行网络操作，等待有返回结果，使用handler通知UI

    }

    List<SyBaen> list;
    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        setupDrawerContent(navigationView);



        //----------------------------------------------------------------------------

        mToolbar=(Toolbar)findViewById(R.id.tl_custom);
        mToolbar.setTitle("爱美女");//设置Toolbar标题
        mToolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };

    //----------------------------------------------------------------------------
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        View headerView = navigationView.getHeaderView(0);
        final ImageView imageView= (ImageView) headerView.findViewById(R.id.imageView);
        imageView.setOnClickListener(this);
               UserName= (TextView) headerView.findViewById(R.id.UserName);


        /**
         * 浮动图标下方波浪
         */
        WaveView3 waveView3 = (WaveView3) headerView.findViewById(R.id.imageViewT);
        final FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2,-2);
        lp.gravity = Gravity.BOTTOM|Gravity.CENTER;
        waveView3.setOnWaveAnimationListener(new WaveView3.OnWaveAnimationListener() {
            @Override
            public void OnWaveAnimation(float y) {
                lp.setMargins(0,0,0,(int)y+2);
                imageView.setLayoutParams(lp);
            }
        });
        fm.beginTransaction().replace(R.id.content_frame,new HomeFragment(),"t"+0).commit();


    }

    private void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener()
                {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem)
                    {
                        menuItem.setChecked(true);
                        switch (menuItem.getItemId()){
                            case R.id.nav_gallery:
                                fm.beginTransaction().replace(R.id.content_frame,new SexyFragment(),"t"+1).commit();
                                break;
                            case R.id.nav_camera:
                            fm.beginTransaction().replace(R.id.content_frame,new HomeFragment(),"t"+0).commit();
                            break;
                            case R.id.nav_slideshow:
                                fm.beginTransaction().replace(R.id.content_frame,new FreshlyPicture(),"t"+0).commit();
                                break;
                        }
                        if (mDrawerLayout.isShown()) {
                            mDrawerLayout.closeDrawers();
                        }
                        return true;
                    }
                });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case  R.id.imageView:
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PgyUpdateManager.unregister();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(UserUtils.getUserBase()!=null){
            String name= UserUtils.getUserBase().getUsername();
            UserName.setText(name);
        }


    }
}
