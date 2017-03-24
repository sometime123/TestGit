package com.example.black_jack.mvp.beans;

/**
 * Created by Black_Jack on 2016/4/26.
 */
public class UserBean {
    //Model层:包含有一个实体UserBean（beans）用来承载数据    和UserBiz(biz)来对登陆数据判断


    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
