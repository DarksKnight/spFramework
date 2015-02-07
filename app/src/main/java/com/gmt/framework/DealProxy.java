package com.gmt.framework;

import com.gmt.entity.BaseEntity;
import com.gmt.model.CommonModel;
import com.gmt.rule.CommonRule;

/**
 * Created by apple on 1/25/15.
 */
public abstract class DealProxy {
    /**
     * 关联model（有规则）
     * @param entity 数据源
     * @param rule 规则
     */
    public abstract void dealModel(BaseEntity entity,CommonRule rule);

    /**
     * 关联model（无规则）
     * @param entity 数据源
     */
    public abstract void dealModel(BaseEntity entity);

    /**
     * 关联view
     * @param obj 监听
     * @param model 请求
     */
    public abstract DealProxyer dealView(ObjectsCallBack.ObjectCallBack obj,CommonModel... models);

    /**
     * 两次请求操作
     * @param objs 执行两个的请求监听
     * @param models 多个请求
     */
    public abstract DealProxyer dealView(ObjectsCallBack.TwoObjectCallBack objs,CommonModel... models);

    /**
     * 三次请求操作
     * @param objs 执行三个的请求监听
     * @param models 多个请求
     */
    public abstract DealProxyer dealView(ObjectsCallBack.ThreeObjectCallBack objs,CommonModel... models);

    /**
     * 四次请求操作
     * @param objs 执行三个的请求监听
     * @param models 多个请求
     */
    public abstract DealProxyer dealView(ObjectsCallBack.FourObjectCallBack objs,CommonModel... models);

    /**
     * 设置第一次请求的参数
     * @param params 请求参数
     */
    public abstract DealProxyer setFirstRequestParams(RequestParams params);

    /**
     * 设置如果请求失败，是否继续请求
     * @param flag 标志 true:失败后继续请求 false:失败后不继续请求
     */
    public abstract DealProxyer setIsContinueModel(boolean flag);

    /**
     * 关联接口，判断成功和失败
     */
    public interface DealObserve{
        void onSuccess(BaseEntity entity);
        void onFail(String error);
    }
}