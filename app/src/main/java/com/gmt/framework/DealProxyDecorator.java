package com.gmt.framework;

/**
 * Created by apple on 2/7/15.
 */
public abstract class DealProxyDecorator extends DealProxy {

    protected DealProxy dealProxy;
    public DealProxyDecorator(){}

    public DealProxyDecorator(DealProxy dealProxy){
        this.dealProxy=dealProxy;
    }
}
