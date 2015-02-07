package com.gmt.framework;

import com.gmt.entity.BaseEntity;
import com.gmt.model.CommonModel;
import com.gmt.rule.CommonRule;

/**
 * Created by apple on 2/7/15.
 */
public class DealProxyWrapper extends DealProxyDecorator {

    private volatile static DealProxyWrapper singleton;

    private DealProxyWrapper(DealProxy dealProxy){
        super(dealProxy);
    }

    public static DealProxyWrapper getInstance() {
        if (singleton == null) {
            synchronized (DealProxyWrapper.class) {
                if (singleton == null) {
                    singleton = new DealProxyWrapper(DealProxyer.getInstance());
                }
            }
        }
        return singleton;
    }

    @Override
    public void dealModel(BaseEntity entity, CommonRule rule) {
        dealProxy.dealModel(entity, rule);
    }

    @Override
    public void dealModel(BaseEntity entity) {
        dealProxy.dealModel(entity);
    }

    @Override
    public DealProxyer dealView(ObjectsCallBack.ObjectCallBack obj, CommonModel... models) {
        return dealProxy.dealView(obj,models);
    }

    @Override
    public DealProxyer dealView(ObjectsCallBack.TwoObjectCallBack objs, CommonModel... models) {
        return dealProxy.dealView(objs, models);
    }

    @Override
    public DealProxyer dealView(ObjectsCallBack.ThreeObjectCallBack objs, CommonModel... models) {
        return dealProxy.dealView(objs,models);
    }

    @Override
    public DealProxyer dealView(ObjectsCallBack.FourObjectCallBack objs, CommonModel... models) {
        return dealProxy.dealView(objs,models);
    }

    @Override
    public DealProxyer setFirstRequestParams(RequestParams params) {
        return dealProxy.setFirstRequestParams(params);
    }

    @Override
    public DealProxyer setIsContinueModel(boolean flag) {
        return dealProxy.setIsContinueModel(flag);
    }
}
