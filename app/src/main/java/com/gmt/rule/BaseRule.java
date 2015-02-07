package com.gmt.rule;

import com.gmt.entity.BaseEntity;
import com.gmt.framework.DealProxyer;

/**
 * Created by apple on 1/25/15.
 */
public class BaseRule extends CommonRule<BaseEntity> {

    private static BaseRule baseRule;

    private BaseRule(){}

    public static BaseRule getInstance(){
        if(baseRule==null)
            baseRule=new BaseRule();
        return baseRule;
    }

    @Override
    public CommonRule dealEntity(BaseEntity entity) {
        if(!entity.getStatus().equals("0")){
            observe.onFail(entity.getErrMeg().trim().length() == 0 ? "请求失败" : entity.getErrMeg());
        }else{
            observe.onSuccess(entity);
        }
        return super.dealEntity(entity);
    }

    @Override
    public CommonRule setDealObserve(DealProxyer.DealObserve observe) {
        this.observe=observe;
        return super.setDealObserve(observe);
    }
}
