package com.example.xzhoumo02.prenester;

import com.example.xzhoumo02.bean.GoodsBean;
import com.example.xzhoumo02.model.Xiangqing;
import com.example.xzhoumo02.newWork.OnNetLinter;
import com.example.xzhoumo02.view.ISuccess;

/**
 * Created by 绅丶士 on 2017/12/9.
 */

public class XiangqingPrecenter {
    private Xiangqing xiangqing;
    private ISuccess success;

    public XiangqingPrecenter(ISuccess success) {
        this.xiangqing = new Xiangqing();
        this.success = success;
    }

    public void getGoodsXiangQing(String getgoodsId){

        xiangqing.getXiangQing(getgoodsId, new OnNetLinter<GoodsBean>() {
            @Override
            public void onSucc(GoodsBean goodsBean) {
                success.GoodsShow(goodsBean);
            }

            @Override
            public void onFile(String str) {

            }
        });
    }
}
