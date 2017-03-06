package com.example.mrpeng.aimeinv.Activity;

import android.graphics.Rect;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mrpeng.aimeinv.R;
import com.squareup.picasso.Picasso;

public class ParticularsActivity extends BaseActivity {
  public static String EXTRA_IMAGE="image";
    private Rect mRect;
    private int mRescourceId;
    private int mOriginWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulars);
      ImageView image= (ImageView) findViewById(R.id.image);
        ViewCompat.setTransitionName(image,EXTRA_IMAGE);
       String URL =getIntent().getStringExtra("URL");
        Picasso.with(ParticularsActivity.this)
                .load(URL).resize(470,700)
                .into(image);

    }

//    private void initial( ImageView image) {
//        // 获取上一个界面传入的信息
//        mRect = getIntent().getSourceBounds();
//        mRescourceId = getIntent().getExtras().getInt(EXTRA_IMAGE);
//
//        // 获取上一个界面中，图片的宽度和高度
//        mOriginWidth = mRect.right - mRect.left;
//        mOriginHeight = mRect.bottom - mRect.top;
//
//        // 设置 ImageView 的位置，使其和上一个界面中图片的位置重合
//        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(mOriginWidth, mOriginHeight);
//        params.setMargins(mRect.left, mRect.top - getStatusBarHeight(), mRect.right, mRect.bottom);
//        image.setLayoutParams(params);
//
//        // 设置 ImageView 的图片和缩放类型
//        image.setImageResource(mRescourceId);
//        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
//
//        // 根据上一个界面传入的图片资源 ID，获取图片的 Bitmap 对象。
//        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(mRescourceId);
//        Bitmap bitmap = bitmapDrawable.getBitmap();
//
//        // 计算图片缩放比例和位移距离
//        getBundleInfo(bitmap);
//
//        // 创建一个 Pallette 对象
//        mImagePalette = Palette.from(bitmap).generate();
//        // 使用 Palette 设置背景颜色
//        mContainer.setBackgroundColor(
//                mImagePalette.getVibrantColor(ContextCompat.getColor(this, android.R.color.black)));
//    }
}
