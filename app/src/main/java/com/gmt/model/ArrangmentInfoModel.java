package com.gmt.model;

import com.gmt.entity.BaseEntity;
import com.gmt.entity.arrangementinfo.ArrangementInfoEntity;
import com.gmt.framework.DealProxyWrapper;
import com.gmt.framework.Request;
import com.gmt.framework.RequestCallBack;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by apple on 1/25/15.
 */
public class ArrangmentInfoModel extends CommonModel {

    private volatile static ArrangmentInfoModel singleton;

    public static ArrangmentInfoModel getInstance() {
        if (singleton == null) {
            synchronized (ArrangmentInfoModel.class) {
                if (singleton == null) {
                    singleton = new ArrangmentInfoModel();
                }
            }
        }
        return singleton;
    }

    @Override
    public void getData() {
        Request.post("", requestParams, new RequestCallBack() {
            @Override
            public void onSuccess(JSONObject response) {
                BaseEntity entity;
                Gson g = new Gson();
                try {
                    entity = g.fromJson("{\"status\":\"1\",\"errMeg\":\"\",\"info\":{\"arrangementInfoList\":[{\"STANDARDSET\":\"abc\"}]}}",ArrangementInfoEntity.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    entity = g.fromJson(response.toString(), BaseEntity.class);
                }
                DealProxyWrapper.getInstance().dealModel(entity);
            }

            @Override
            public void onFail(String error) {

            }
        });
    }
}
