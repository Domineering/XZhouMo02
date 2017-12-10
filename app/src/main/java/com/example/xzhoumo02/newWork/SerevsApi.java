package com.example.xzhoumo02.newWork;

import com.example.xzhoumo02.bean.GoodsBean;
import com.example.xzhoumo02.bean.UserBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 绅丶士 on 2017/12/9.
 */

public interface SerevsApi {
    @GET(UrlUtils.TAG)
    Flowable<UserBean> tags();
    @GET("v5/goods/{good_id}")
    Flowable<GoodsBean> goodstags(@Path("good_id") String goods_id);
}
