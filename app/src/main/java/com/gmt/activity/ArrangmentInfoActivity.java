package com.gmt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.gmt.R;
import com.gmt.adapter.ArrangmentInfoAdapter;
import com.gmt.entity.arrangementinfo.ArrangementInfoListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 1/25/15.
 */
public class ArrangmentInfoActivity extends ActionBarActivity {

    private final List<ArrangementInfoListItem> arrangementInfoList=new ArrayList<>();
    private ArrangmentInfoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrangmentinfo);

        ListView lv=(ListView)findViewById(R.id.lv);
        Button add=(Button)findViewById(R.id.add);

        adapter=new ArrangmentInfoAdapter(this,arrangementInfoList,R.layout.item_arrangmentinfo);
        lv.setAdapter(adapter);
        initData();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ArrangmentInfoActivity.this,ArrangementAddActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData(){
//        RequestParams requestParams= com.gmt.framework.RequestParams.getInstance();
//        requestParams.put("userId", StaticField.USER.getUserID());
//        requestParams.put("projectId", "1");
//
//        DealProxy.getInstance().dealView(new ObjectCallBack<ArrangementInfoEntity>() {
//            @Override
//            public void getData(ArrangementInfoEntity obj) {
//
//                for(ArrangementInfoListItem o:obj.getInfo().getArrangementInfoList()){
//                    arrangementInfoList.add(o);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void getError(String error) {
//                Toast.makeText(ArrangmentInfoActivity.this, error, Toast.LENGTH_SHORT).show();
//            }
//        }, new ArrangmentInfoModel(requestParams));
    }
}
