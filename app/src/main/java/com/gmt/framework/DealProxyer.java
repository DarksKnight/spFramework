package com.gmt.framework;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.gmt.entity.BaseEntity;
import com.gmt.model.CommonModel;
import com.gmt.rule.BaseRule;
import com.gmt.rule.CommonRule;

/**
 * Created by apple on 2/7/15.
 */
public class DealProxyer extends DealProxy {
    private static DealProxyer dealProxy;
    private ObjectsCallBack.BaseObjectsCallBack objsCallBack;
    private ModelManager modelManager=new ModelManagerImpl();
    private boolean mFlag=true;

    private volatile static DealProxyer singleton;

    public static DealProxyer getInstance() {
        if (singleton == null) {
            synchronized (DealProxyer.class) {
                if (singleton == null) {
                    singleton = new DealProxyer();
                }
            }
        }
        return singleton;
    }

    @Override
    public void dealModel(BaseEntity entity,CommonRule rule){
        dealData(entity,rule);
    }

    @Override
    public void dealModel(BaseEntity entity){
        dealDefaultData(entity);
    }

    @Override
    public DealProxyer dealView(ObjectsCallBack.ObjectCallBack obj,CommonModel... models){
        objsCallBack=obj;
        commonSetModelInfo(models);
        Log.i("TEST", "dealView");
        return this;
    }

    @Override
    public DealProxyer dealView(ObjectsCallBack.TwoObjectCallBack objs,CommonModel... models){
        objsCallBack=objs;
        commonSetModelInfo(models);
        return this;
    }

    @Override
    public DealProxyer dealView(ObjectsCallBack.ThreeObjectCallBack objs,CommonModel... models){
        objsCallBack=objs;
        commonSetModelInfo(models);
        return this;
    }

    @Override
    public DealProxyer dealView(ObjectsCallBack.FourObjectCallBack objs,CommonModel... models){
        objsCallBack=objs;
        commonSetModelInfo(models);
        return this;
    }

    @Override
    public DealProxyer setFirstRequestParams(RequestParams params){
        modelManager.getModel(0).setParams(params);
        Log.i("TEST","setFirstRequestParams");
        return this;
    }

    @Override
    public DealProxyer setIsContinueModel(boolean flag){
        this.mFlag=flag;
        return this;
    }

    /**
     * 处理数据（有规则）
     * @param entity 数据源
     * @param rule 规则
     */
    private void dealData(BaseEntity entity,CommonRule rule){
        rule.setDealObserve(new DealObserve() {
            @Override
            public void onSuccess(BaseEntity entity) {
                commonSuccessMethod(entity);
            }

            @Override
            public void onFail(String error) {
                commonFailMethod(error);
            }
        }).dealEntity(entity);
    }

    /**
     * 处理数据（无规则，使用默认规则）
     * 内部采用分发机制
     * @param entity 数据源
     */
    private void dealDefaultData(BaseEntity entity){
        BaseRule.getInstance().setDealObserve(new DealObserve() {
            @Override
            public void onSuccess(BaseEntity entity) {
                commonSuccessMethod(entity);
            }

            @Override
            public void onFail(String error) {
                commonFailMethod(error);
            }
        }).dealEntity(entity);
    }

    /**
     * 当一个请求结束过后才能继续执行下一个请求
     */
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Log.i("TEST","handleMessage");
            modelManager.doModel(objsCallBack.innerParams);
        }
    };

    /**
     * 设置model信息
     * @param models
     */
    private void commonSetModelInfo(CommonModel... models){
        if(models.length==1)
            modelManager.setModel(models[0]);
        else
            modelManager.setModels(models);
        handler.sendEmptyMessage(0);
        Log.i("TEST", "dealView");
    }

    /**
     * 请求成功，设置对象传递到view层并且继续下一个model
     * @param entity 数据源
     */
    private void commonSuccessMethod(BaseEntity entity){
        DealProxyUtil.setData(entity,objsCallBack,modelManager.getModels().length,modelManager.getmIndex());
        continueDoModel();
    }

    /**
     * 请求失败，设置错误信息传递到view层
     * 判断当前是否请求失败后继续请求
     * @param error 错误信息
     */
    private void commonFailMethod(String error){
        DealProxyUtil.setFail(error,modelManager.getModels().length,objsCallBack,modelManager.getmIndex());
        if(this.mFlag){
            continueDoModel();
        }else{
            modelManager.removeAll();
        }
    }

    /**
     * 继续执行model
     */
    private void continueDoModel(){
        if(modelManager.getmIndex()==modelManager.getModels().length-1){
            return;
        }else{
            handler.sendEmptyMessage(0);
        }
    }
}
