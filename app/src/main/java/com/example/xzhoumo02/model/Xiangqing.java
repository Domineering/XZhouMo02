package com.example.xzhoumo02.model;

import com.example.xzhoumo02.bean.GoodsBean;
import com.example.xzhoumo02.newWork.OnNetLinter;
import com.example.xzhoumo02.newWork.RetrofitHodel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 绅丶士 on 2017/12/9.
 */

public class Xiangqing {
    public void getXiangQing(String goods_id, final OnNetLinter<GoodsBean> onNetLinter){
        RetrofitHodel.getApi().goodstags(goods_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodsBean>() {
                    @Override
                    public void accept(GoodsBean goodsBean) throws Exception {
                        onNetLinter.onSucc(goodsBean);
                    }

                });
    }
}
