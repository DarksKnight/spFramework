package com.gmt.model;

import com.gmt.entity.BaseEntity;
import com.gmt.entity.login.LoginEntity;
import com.gmt.framework.DealProxyWrapper;
import com.gmt.framework.Request;
import com.gmt.framework.RequestCallBack;
import com.gmt.rule.LoginRule;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by apple on 1/24/15.
 */
public class LoginModel extends CommonModel {

    private volatile static LoginModel singleton;

    public static LoginModel getInstance() {
        if (singleton == null) {
            synchronized (LoginModel.class) {
                if (singleton == null) {
                    singleton = new LoginModel();
                }
            }
        }
        return singleton;
    }

    @Override
    public void getData() {
        Request.post("",requestParams,new RequestCallBack() {
            @Override
            public void onSuccess(JSONObject response) {
                BaseEntity entity;
                Gson g=new Gson();
                try{
                    entity=g.fromJson("{\"status\":\"0\",\"errMeg\":\"\",\"info\":{\"userID\":\"2\"}}",LoginEntity.class);
                }catch (Exception e){
                    e.printStackTrace();
                    entity=g.fromJson(response.toString(),BaseEntity.class);
                }
                DealProxyWrapper.getInstance().dealModel(entity,new LoginRule());
            }

            @Override
            public void onFail(String error) {

            }
        });
    }

}
