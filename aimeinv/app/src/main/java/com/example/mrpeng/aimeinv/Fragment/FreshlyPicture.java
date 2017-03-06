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
import com.example.mrpeng.aimeinv.Adapter.FreshlyAdapter;
import com.example.mrpeng.aimeinv.Adapter.HomeRecyAdapter;
import com.example.mrpeng.aimeinv.Baen.FreshlyPictureBase;
import com.example.mrpeng.aimeinv.Baen.SyBaen;
import com.example.mrpeng.aimeinv.Http.HomeHttp;
import com.example.mrpeng.aimeinv.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;


public class FreshlyPicture extends Fragment {
    View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.fragment_freshly_picture, container, false);
        HomeHttp.GetfreshiyData(mHandler,1,getActivity());

        return mView;
    }

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                   String jsonString=(String) msg.obj;
                    Gson gson=new Gson();
                     FreshlyPictureBase pictureBase = gson.fromJson(jsonString, FreshlyPictureBase.class);
                    final List<FreshlyPictureBase.ItemsBean> list = pictureBase.getItems();
                    RecyclerView recyclerView= (RecyclerView) mView.findViewById(R.id.recyclerView);
                    GridLayoutManager Gm=new GridLayoutManager(getActivity(),2, LinearLayoutManager.VERTICAL,false);
                    recyclerView.setLayoutManager(Gm);
                    FreshlyAdapter adapter = new FreshlyAdapter(getActivity(), R.layout.homerecyviewitem, list);

                    recyclerView.setAdapter(adapter);
                    adapter.setOnItemClickListner(new BaseAdapter.RecyViewonItemClick() {
                        @Override
                        public void onItemClick(View v, final int position) {
                            final View mImagev = (View) v.findViewById(R.id.image);


                            final String ImageUrl="http://7xq0d5.com2.z0.glb.qiniucdn.com/";

                            Picasso.with(getActivity()).load(ImageUrl+list.get(position).getPicture()).resize(470,700).fetch(new com.squareup.picasso.Callback() {

                                @Override public void onSuccess() {

                                    Intent intent = new Intent();
                                    intent.setClass(getActivity(), ParticularsActivity.class);
                                    intent.putExtra("URL",ImageUrl+ list.get(position).getPicture());
                                    //元素交互
                                    ActivityOptionsCompat compat = ActivityOptionsCompat
                                            .makeSceneTransitionAnimation(getActivity(), Pair.create(mImagev, ParticularsActivity.EXTRA_IMAGE));
                                    ActivityCompat.startActivity(getActivity(), intent, compat.toBundle());

                                }


                                @Override public void onError() {}
                            });
                        }
                    });


                    break;
            }

        }
    };

}
