package com.example.black_jack.mvp.biz;

import com.example.black_jack.mvp.beans.UserBean;

/**
 * Created by Black_Jack on 2016/4/26.
 */

public interface UserBiz {
    ////Model层: 通过抽象出一个接口UserBiz来对登陆数据判断
    //建立model（处理业务逻辑，这里指数据读写），先写接口，后写实现
    //biz是Business的缩写，实际上就是控制层（业务逻辑层）


    void login(UserBean userBean);
}
