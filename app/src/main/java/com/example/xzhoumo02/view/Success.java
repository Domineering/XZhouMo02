package com.example.xzhoumo02.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.xzhoumo02.R;
import com.example.xzhoumo02.bean.GoodsBean;
import com.example.xzhoumo02.prenester.XiangqingPrecenter;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class Success extends AppCompatActivity implements ISuccess {

    private String aaaa;
    private Banner mBan;
    private GoodsBean.GalleryBean galleryBean;
    private List<String> listimg=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        initView();
        Intent intent = getIntent();
        aaaa = intent.getStringExtra("aaaa");
        Toast.makeText(Success.this, aaaa, Toast.LENGTH_LONG).show();

        XiangqingPrecenter xiangqingPrecenter = new XiangqingPrecenter(this);
        xiangqingPrecenter.getGoodsXiangQing(aaaa);
    }

    @Override
    public String getgoodsId() {
        return aaaa;
    }

    @Override
    public void GoodsShow(GoodsBean goodsBean) {
        listimg.clear();
        List<GoodsBean.GalleryBean> gallery = goodsBean.getGallery();
        for (int i = 0; i <gallery.size() ; i++) {
            galleryBean = gallery.get(i);
            listimg.add(galleryBean.getUrl());
        }
        mBan.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBan.setImages(listimg);
        //banner设置方法全部调用完毕时最后调用
        mBan.start();
    }

    private void initView() {
        mBan = (Banner) findViewById(R.id.ban);
    }
}
