package com.gmt.framework;

import com.gmt.entity.BaseEntity;

/**
 * Created by apple on 2/7/15.
 */
public class DealProxyUtil {

    /**
     * 将对象传递到view层
     * @param entity 数据源
     * @param objsCallBack 回调，将数据传递到view层
     * @param modelSize model个数
     * @param index model指数
     */
    public static void setData(BaseEntity entity,ObjectsCallBack.BaseObjectsCallBack objsCallBack,int modelSize,int index){
        switch (modelSize){
            case 1:
                ((ObjectsCallBack.ObjectCallBack)objsCallBack).getData(entity);
                break;
            case 2:
                if(index==0)
                    ((ObjectsCallBack.TwoObjectCallBack)objsCallBack).getOneData(entity);
                else if(index==1)
                    ((ObjectsCallBack.TwoObjectCallBack)objsCallBack).getTwoData(entity);
                break;
            case 3:
                if(index==0)
                    ((ObjectsCallBack.ThreeObjectCallBack)objsCallBack).getOneData(entity);
                else if(index==1)
                    ((ObjectsCallBack.ThreeObjectCallBack)objsCallBack).getTwoData(entity);
                else if(index==2)
                    ((ObjectsCallBack.ThreeObjectCallBack)objsCallBack).getThreeData(entity);
                break;
            case 4:
                if(index==0)
                    ((ObjectsCallBack.FourObjectCallBack)objsCallBack).getOneData(entity);
                else if(index==1)
                    ((ObjectsCallBack.FourObjectCallBack)objsCallBack).getTwoData(entity);
                else if(index==2)
                    ((ObjectsCallBack.FourObjectCallBack)objsCallBack).getThreeData(entity);
                else if(index==3)
                    ((ObjectsCallBack.FourObjectCallBack)objsCallBack).getFourData(entity);
                break;
            default:
                break;
        }
    }

    /**
     * 将错误信息传递到view层
     * @param error
     * @param modelSize
     * @param objsCallBack
     * @param index
     */
    public static void setFail(String error,int modelSize,ObjectsCallBack.BaseObjectsCallBack objsCallBack,int index){
        switch (modelSize){
            case 1:
                ((ObjectsCallBack.ObjectCallBack)objsCallBack).getError(error);
                break;
            case 2:
                ((ObjectsCallBack.TwoObjectCallBack)objsCallBack).getError(error);
                break;
            case 3:
                ((ObjectsCallBack.ThreeObjectCallBack)objsCallBack).getError(error);
                break;
            case 4:
                ((ObjectsCallBack.FourObjectCallBack)objsCallBack).getError(error);
                break;
        }
    }
}
