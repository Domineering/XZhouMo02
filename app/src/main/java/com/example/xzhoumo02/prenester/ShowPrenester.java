package com.example.xzhoumo02.prenester;

import android.content.Context;

import com.example.xzhoumo02.bean.UserBean;
import com.example.xzhoumo02.model.ShowModel;
import com.example.xzhoumo02.newWork.OnNetLinter;
import com.example.xzhoumo02.view.IMainActivity;

/**
 * Created by 绅丶士 on 2017/12/9.
 */

public class ShowPrenester {
    Context context;
    IMainActivity iMainActivity;
    ShowModel showModel;

    public ShowPrenester(Context context, IMainActivity iMainActivity) {
        this.context = context;
        this.iMainActivity = iMainActivity;
        showModel=new ShowModel();
    }

    //创建方法
    public void getshow(){
        showModel.shuju(new OnNetLinter<UserBean>() {
            @Override
            public void onSucc(UserBean userBean) {
                iMainActivity.show(userBean);

            }

            @Override
            public void onFile(String str) {

            }
        });
    }
}
