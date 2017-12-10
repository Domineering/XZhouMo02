package com.example.xzhoumo02.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.xzhoumo02.R;
import com.example.xzhoumo02.bean.UserBean;
import com.example.xzhoumo02.newWork.OnClikLinter;
import com.example.xzhoumo02.newWork.OnNetLinter;
import com.example.xzhoumo02.view.Success;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import retrofit2.http.Url;

/**
 * Created by 绅丶士 on 2017/12/9.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private Context context;
    private List<UserBean.GoodsListBean> list;
    private LayoutInflater inflater;
    private OnClikLinter onClikLinter;

    public MyAdapter(Context context, List<UserBean.GoodsListBean> list,OnClikLinter onClikLinter) {
        this.context = context;
        this.list = list;
        this.onClikLinter=onClikLinter;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
                MyViewHolder myViewHolder=holder;
                 final UserBean.GoodsListBean goodsListBean = list.get(position);
        Uri uri=Uri.parse(goodsListBean.getImage_url());
        myViewHolder.image.setImageURI(uri);
        myViewHolder.tv_title.setText(goodsListBean.getShort_name());
        myViewHolder.tv_price.setText("¥"+goodsListBean.getNormal_price()+"");
        myViewHolder.rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClikLinter.OnClikLinter(goodsListBean.getGoods_id()+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView image;
        private final TextView tv_title;
        private final TextView tv_price;
        private final RelativeLayout rel;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_price = itemView.findViewById(R.id.tv_price);
            rel = itemView.findViewById(R.id.rel);
        }
    }
}
