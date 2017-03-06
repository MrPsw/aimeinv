package com.example.mrpeng.aimeinv.Fragment;

import android.content.Context;
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.bumptech.glide.Glide;
import com.example.mrpeng.aimeinv.Activity.ParticularsActivity;
import com.example.mrpeng.aimeinv.Adapter.BaseAdapter;
import com.example.mrpeng.aimeinv.Adapter.HomeRecyAdapter;
import com.example.mrpeng.aimeinv.Baen.SyBaen;
import com.example.mrpeng.aimeinv.Http.HomeHttp;

import com.example.mrpeng.aimeinv.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HomeFragment extends Fragment {

    List IMAGES= new ArrayList();
    List TITLE=new ArrayList();
    private Map<String, String> map;
    private Banner banner;
    private RecyclerView recyclerView;
    private View view;


    public HomeFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home, container, false);

        banner = (Banner)view. findViewById(R.id.banner);
        HomeHttp.Getadvertisement(h,1);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        HomeHttp.GetREcyData(h,2);

        return view;
    }








    public class GlideImageLoader implements ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }

    Handler h=new Handler( ){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    List<SyBaen> list1= (List<SyBaen>) msg.obj;
                    if(list1.size()>0){
                        for(int i=0;i<list1.size();i++){
                            IMAGES.add(list1.get(i).getImageSrc());
                            TITLE.add(list1.get(i).getAlt());

                        }

                        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
                        banner.setImageLoader(new GlideImageLoader());
                        banner.setImages(IMAGES);
                        banner.setBannerAnimation(Transformer.DepthPage);
                        banner.setBannerTitles(TITLE);
                        banner.isAutoPlay(true);
                        banner.setDelayTime(1500);
                        banner.setIndicatorGravity(BannerConfig.CENTER);
                        banner.start();
                    }
                    break;
                case 2:

                    final List<SyBaen> list2= (List<SyBaen>) msg.obj;
                   if (list2!=null) {
                       GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
                       recyclerView.setLayoutManager(layoutManager);
                       RecyclerViewHeader header = (RecyclerViewHeader) view.findViewById(R.id.header);
                       header.attachTo(recyclerView, true);
                       HomeRecyAdapter adapter = new HomeRecyAdapter(getActivity(), R.layout.homerecyviewitem, list2);
                       Log.e("布局文件",R.layout.homerecyviewitem+"");
                       if(adapter!=null){
                           recyclerView.setAdapter(adapter);
                           adapter.notifyDataSetChanged();
                       }

                       adapter.setOnItemClickListner(new BaseAdapter.RecyViewonItemClick() {
                           @Override
                           public void onItemClick(View v, final int position) {
                               final View mImagev = (View) v.findViewById(R.id.image);




                               Picasso.with(getActivity()).load(list2.get(position).getImageSrc()).resize(470,700).fetch(new com.squareup.picasso.Callback() {

                                   @Override public void onSuccess() {
                                       Intent intent = new Intent();
                                       intent.setClass(getActivity(), ParticularsActivity.class);
                                       intent.putExtra("URL", list2.get(position).getImageSrc());
                                       //元素交互
                                       ActivityOptionsCompat compat = ActivityOptionsCompat
                                               .makeSceneTransitionAnimation(getActivity(), Pair.create(mImagev, ParticularsActivity.EXTRA_IMAGE));
                                       ActivityCompat.startActivity(getActivity(), intent, compat.toBundle());

                                   }


                                   @Override public void onError() {}
                               });




//                                       //由某个位置放大
//                                       ActivityOptionsCompat compat = ActivityOptionsCompat.makeScaleUpAnimation(mImagev,
//                                               mImagev.getWidth() / 2, mImagev.getHeight() / 2, 0, 0);
//                                       ActivityCompat.startActivity(getActivity(), intent,
//                                               compat.toBundle());




                           }
                       });
                   }
                    break;
            }
        }
    };
}
