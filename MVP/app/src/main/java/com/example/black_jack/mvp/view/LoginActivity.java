package com.example.black_jack.mvp.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.black_jack.mvp.R;
import com.example.black_jack.mvp.presenter.LoginPresenter;
import com.example.black_jack.mvp.presenter.LoginPresenterImp;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    //在Activity里面实现LoginView的控件操作,并且初始化Presenter,
    // 这里可以看到Activity里面没有逻辑处理,只是对UI的控件进行数据或者行为的操作,
    // 所有的动作都是由Presenter的接口来实现，这样在项目里面会极大得精简Activity的体积.

    @Bind(R.id.editText)
    EditText mUsername;
    @Bind(R.id.editText2)
    EditText mPassword;
    @Bind(R.id.button)
    Button mLogin;
    @Bind(R.id.button2)
    Button mClear;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenterImp(this);
    }

    @Override
    public String getUsername() {
        return mUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString();
    }

    @Override
    public void showMessage(String msg) {
        Snackbar.make(getCurrentFocus(), msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void clear() {
        mUsername.setText("");
        mPassword.setText("");
    }

    @OnClick({R.id.button, R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                loginPresenter.login();
                break;
            case R.id.button2:
                loginPresenter.clear();
                break;


        }
    }
}
