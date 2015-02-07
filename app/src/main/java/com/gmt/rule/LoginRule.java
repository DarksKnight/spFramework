package com.gmt.rule;

import com.gmt.entity.login.LoginEntity;
import com.gmt.framework.DealProxyer;

/**
 * Created by apple on 1/25/15.
 */
public class LoginRule extends CommonRule<LoginEntity>{

    @Override
    public CommonRule dealEntity(LoginEntity entity) {
        if(entity.getStatus().equals("0")){
            entity.getInfo().setUserID("100");
            observe.onSuccess(entity);
        }else{
            observe.onFail("请求失败");
        }
        return super.dealEntity(entity);
    }

    @Override
    public CommonRule setDealObserve(DealProxyer.DealObserve observe) {
        return super.setDealObserve(observe);
    }
}
