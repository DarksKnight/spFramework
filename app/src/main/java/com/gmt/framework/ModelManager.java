package com.gmt.framework;

import com.gmt.model.CommonModel;

/**
 * Created by apple on 2/7/15.
 */
public interface ModelManager {
    /**
     * 执行model
     */
    void doModel(RequestParams params);

    /**
     * 放入多个model
     * @param mModels
     */
    void setModels(CommonModel[] mModels);

    /**
     * 放入一个model
     * @param mModel
     */
    void setModel(CommonModel mModel);

    /**
     * 获取指定的model
     * @param index
     * @return
     */
    CommonModel getModel(int index);

    /**
     * 获取所有model
     * @return
     */
    CommonModel[] getModels();

    /**
     * 清除所有model
     */
    void removeAll();

    /**
     * 清除指定的model
     * @param index
     */
    void removeAt(int index);

    /**
     * 清除指定的model，并且设置索引
     * @param modelIndex
     * @param mIndex
     */
    void removeAt(int modelIndex,int mIndex);

    /**
     * 获得当前索引
     * @return
     */
    int getmIndex();
}
