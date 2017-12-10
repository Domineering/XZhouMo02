package com.example.xzhoumo02.newWork;

/**
 * Created by 绅丶士 on 2017/12/9.
 */

public interface OnNetLinter<T> {
    void onSucc(T t);
    void onFile(String str);
}
