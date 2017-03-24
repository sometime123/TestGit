package com.example.black_jack.mvp.biz;

import com.example.black_jack.mvp.beans.UserBean;
import com.example.black_jack.mvp.listener.OnLoginListener;

/**
 * Created by Black_Jack on 2016/4/26.
 */
public class UserBizImpl implements UserBiz {
    //建立model（处理业务逻辑，这里指数据读写），先写接口，后写实现
    //UserBizImpl实例化接口,并且通过登陆监听将结果回调给Presenter

     private OnLoginListener onLoginListener;

     public UserBizImpl(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    @Override
    public void login(final UserBean userBean) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("123".equals(userBean.getUsername()) && "123".equals(userBean.getPassword())) {
                    onLoginListener.done(true);
                } else {
                    onLoginListener.done(false);
                }
            }
        }).start();

    }
}
