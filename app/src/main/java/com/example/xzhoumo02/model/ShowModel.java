package com.example.xzhoumo02.model;

import com.example.xzhoumo02.bean.UserBean;
import com.example.xzhoumo02.newWork.OnNetLinter;
import com.example.xzhoumo02.newWork.RetrofitHodel;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 绅丶士 on 2017/12/9.
 */

public class ShowModel implements IShowModel{
    @Override
    public void shuju(final OnNetLinter<UserBean> onNetLinter) {
        RetrofitHodel.getApi().tags()
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserBean>() {
                    @Override
                    public void accept(UserBean userBean) throws Exception {
                        onNetLinter.onSucc(userBean);
                    }
                });
    }
}
