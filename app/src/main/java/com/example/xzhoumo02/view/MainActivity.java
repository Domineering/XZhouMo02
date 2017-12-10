package com.example.xzhoumo02.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.xzhoumo02.R;
import com.example.xzhoumo02.adapter.MyAdapter;
import com.example.xzhoumo02.bean.UserBean;
import com.example.xzhoumo02.newWork.OnClikLinter;
import com.example.xzhoumo02.prenester.ShowPrenester;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainActivity,OnClikLinter {

    private RecyclerView mRv;
    private List<UserBean.GoodsListBean> lists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //实例化P层
        ShowPrenester showPrenester=new ShowPrenester(this,this);
        showPrenester.getshow();
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        mRv.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void show(UserBean userBean) {
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, userBean.getGoods_list(),this);
        mRv.setAdapter(myAdapter);
    }

    @Override
    public void OnClikLinter(String url) {
        Intent intent = new Intent(MainActivity.this, Success.class);
         intent.putExtra("aaaa",url);
        startActivity(intent);
    }
}
