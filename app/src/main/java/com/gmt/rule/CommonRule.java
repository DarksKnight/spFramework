package com.gmt.rule;

import com.gmt.framework.DealProxyer;

/**
 * Created by apple on 1/25/15.
 */
public abstract class CommonRule<T> {

    DealProxyer.DealObserve observe;

    public CommonRule dealEntity(T entity){
        return this;
    }

    public CommonRule setDealObserve(DealProxyer.DealObserve observe){
        this.observe=observe;
        return this;
    }
}
