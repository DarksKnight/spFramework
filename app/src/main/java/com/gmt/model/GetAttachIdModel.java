package com.gmt.model;

import com.gmt.framework.RequestParams;

/**
 * Created by apple on 1/25/15.
 */
public class GetAttachIdModel extends CommonModel {

    private RequestParams requestParams=null;

    public GetAttachIdModel(RequestParams requestParams){
        this.requestParams=requestParams;
    }

    @Override
    public void getData() {
//        Request.post("", requestParams, new RequestCallBack() {
//            @Override
//            public void onSuccess(JSONObject response) {
//                BaseEntity entity;
//                Gson g = new Gson();
//                try {
//                    entity = g.fromJson(response.toString(),AttachId.class);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    entity = g.fromJson(response.toString(), BaseEntity.class);
//                }
//                DealProxy.getInstance().dealModel(entity);
//            }
//        });
    }
}
