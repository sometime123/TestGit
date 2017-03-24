package com.example.black_jack.mvp.presenter;

import android.net.wifi.WifiConfiguration;
import android.os.Handler;

import com.example.black_jack.mvp.beans.UserBean;
import com.example.black_jack.mvp.biz.UserBiz;
import com.example.black_jack.mvp.biz.UserBizImpl;
import com.example.black_jack.mvp.listener.OnLoginListener;
import com.example.black_jack.mvp.view.LoginView;

import java.util.IllegalFormatCodePointException;

import java.util.logging.LogRecord;

/**
 * Created by Black_Jack on 2016/5/3.
 */
public class LoginPresenterImp implements LoginPresenter, OnLoginListener {

    //在Presenter层里面,Presenter掌握着View和Model的所有接口,
    // Presenter就可以根据不同的业务逻辑：
    // 通过MV两层的接口来实现特定的功能,让M和V独立出来.


    private LoginView loginView;
    private UserBiz userBiz;
    private UserBean userBean = new UserBean();
    private Handler handler = new Handler();

    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
        userBiz = new UserBizImpl(this);

    }

    @Override
    public void login() {
        userBean.setUsername(loginView.getUsername());
        userBean.setPassword(loginView.getPassword());
        userBiz.login(userBean);
    }

    @Override
    public void clear() {
        loginView.clear();
    }

    @Override
    public void done(final boolean status) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (status) {
                    loginView.showMessage("登录成功!");
                } else {
                    loginView.showMessage("用户名或密码不正确!");
                }
            }
        });
    }

}
