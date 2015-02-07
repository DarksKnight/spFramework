package com.gmt.framework;

import org.json.JSONObject;

/**
 * Created by apple on 1/24/15.
 */
public interface RequestCallBack {

    void onSuccess(JSONObject response);

    void onFail(String error);
}
