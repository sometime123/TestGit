package com.example.black_jack.mvp.view;

/**
 * Created by Black_Jack on 2016/5/3.
 */
public interface LoginView {

    //建立view（更新ui中的view状态），这里列出需要操作当前view的方法，也是接口
    //把View层针对控件操作  抽象出来 的接口

    // public abstract
    String getUsername();

    String getPassword();

    void showMessage(String msg);

    void clear();
}
