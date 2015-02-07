package com.gmt.model;

import com.gmt.framework.RequestParams;

/**
 * Created by apple on 1/25/15.
 */
public abstract class CommonModel {

    public RequestParams requestParams=null;

    public void getData(){}

    public CommonModel setParams(RequestParams params){
        this.requestParams=params;
        return this;
    }
}
