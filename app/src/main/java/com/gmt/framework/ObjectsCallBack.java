package com.gmt.framework;

/**
 * Created by sh-sun on 15-2-3.
 */
public class ObjectsCallBack {

    public interface BaseObjectsCallBack{
        RequestParams innerParams=new RequestParams();
    }

    public interface ObjectCallBack extends BaseObjectsCallBack{
        void getData(Object obj);
        void getError(String error);
    }

    public interface TwoObjectCallBack extends BaseObjectsCallBack{
        void getOneData(Object obj);
        void getTwoData(Object obj);
        void getError(String error);
    }

    public interface ThreeObjectCallBack extends BaseObjectsCallBack{
        void getOneData(Object obj);
        void getTwoData(Object obj);
        void getThreeData(Object obj);
        void getError(String error);
    }

    public interface FourObjectCallBack extends BaseObjectsCallBack{
        void getOneData(Object obj);
        void getTwoData(Object obj);
        void getThreeData(Object obj);
        void getFourData(Object obj);
        void getError(String error);
    }

}
