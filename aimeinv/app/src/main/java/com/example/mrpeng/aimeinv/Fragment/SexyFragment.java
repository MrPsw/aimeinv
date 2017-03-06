package com.example.mrpeng.aimeinv.Fragment;


import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrpeng.aimeinv.Activity.ParticularsActivity;
import com.example.mrpeng.aimeinv.Adapter.BaseAdapter;
import com.example.mrpeng.aimeinv.Adapter.HomeRecyAdapter;
import com.example.mrpeng.aimeinv.Baen.SyBaen;
import com.example.mrpeng.aimeinv.Http.HomeHttp;
import com.example.mrpeng.aimeinv.R;

import java.util.List;


public class SexyFragment extends Fragment {





    private View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       v=  inflater.inflate(R.layout.fragment_sexy, container, false);
        HomeHttp.GetxingganData(h,0);

        return v;
    }
Handler h=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what){
            case 0:
                final List<SyBaen> list = (List<SyBaen>) msg.obj;
                RecyclerView recyclerView= (RecyclerView) v.findViewById(R.id.recyclerView);
                GridLayoutManager Gm=new GridLayoutManager(getActivity(),2, LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(Gm);
                HomeRecyAdapter adapter = new HomeRecyAdapter(getActivity(), R.layout.homerecyviewitem, list);

                recyclerView.setAdapter(adapter);
                adapter.setOnItemClickListner(new BaseAdapter.RecyViewonItemClick() {
                    @Override
                    public void onItemClick(View v, int position) {

                        View mImagev= (View) v.findViewById(R.id.image);

                        Intent intent=new Intent();
                        intent.setClass(getActivity(), ParticularsActivity.class);
                        intent.putExtra("URL",list.get(position).getImageSrc());
//                             //由某个位置放大
//                            ActivityOptionsCompat compat = ActivityOptionsCompat.makeScaleUpAnimation(v,
//                                    v.getWidth() / 2, v.getHeight() / 2, 0, 0);
//                            ActivityCompat.startActivity(MainActivity.this, intent,
//                                    compat.toBundle());

                        //元素交互
                        ActivityOptionsCompat compat = ActivityOptionsCompat
                                .makeSceneTransitionAnimation(getActivity(), Pair.create(mImagev, ParticularsActivity.EXTRA_IMAGE));
                        ActivityCompat.startActivity(getActivity(), intent, compat.toBundle());



                    }
                });

                break;
        }
    }
};



}
