package com.gmt.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gmt.R;
import com.gmt.entity.login.LoginEntity;
import com.gmt.framework.DealProxyWrapper;
import com.gmt.framework.ObjectsCallBack;
import com.gmt.framework.RequestParams;
import com.gmt.model.LoginModel;


public class LoginActivity extends ActionBarActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        Button btn_Login=(Button)findViewById(R.id.btn_Login);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }

    private void doLogin() {

        RequestParams onerequestParams = new RequestParams();
        onerequestParams.put("loginId", username.getText().toString());
        onerequestParams.put("passWord", password.getText().toString());

//        DealProxyWrapper.getInstance().dealView(new ObjectsCallBack.TwoObjectCallBack() {
//            @Override
//            public void getOneData(Object obj) {
//                Log.i("TEST", ((LoginEntity) obj).getInfo().getUserID());
//                StaticField.USER = ((LoginEntity) obj).getInfo();
//                //必须清空
//                innerParams.clearAll();
//                innerParams.put("projectId", "1");
//                innerParams.put("userId", StaticField.USER.getUserID());
//            }
//
//            @Override
//            public void getTwoData(Object obj) {
//                Log.i("TEST", ((ArrangementInfoEntity) obj).getInfo().getArrangementInfoList().get(0).getSTANDARDSET());
//            }
//
//            @Override
//            public void getError(String error) {
//                Log.i("TEST", error);
//            }
//        }, LoginModel.getInstance(), ArrangmentInfoModel.getInstance()).setFirstRequestParams(onerequestParams).setIsContinueModel(true);

        DealProxyWrapper.getInstance().dealView(new ObjectsCallBack.ObjectCallBack() {
            @Override
            public void getData(Object obj) {
                Log.i("TEST", ((LoginEntity) obj).getInfo().getUserID());
            }

            @Override
            public void getError(String error) {
                Log.i("TEST", error);
            }
        }, LoginModel.getInstance()).setFirstRequestParams(onerequestParams);
    }
}
