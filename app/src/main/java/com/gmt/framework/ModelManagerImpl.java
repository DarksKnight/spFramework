package com.gmt.framework;

import com.gmt.model.CommonModel;

import java.util.ArrayList;

/**
 * Created by apple on 2/7/15.
 */
public class ModelManagerImpl implements ModelManager {

    private ArrayList<CommonModel> mModels=new ArrayList<>();
    private int mIndex=-1;

    @Override
    public void doModel(RequestParams params) {
        mIndex++;
        mModels.get(mIndex).setParams(params).getData();
        if(mIndex==mModels.size()-1){
            removeAll();
        }
    }

    @Override
    public void setModels(CommonModel[] models) {
        for(CommonModel m:models)
            this.mModels.add(m);
    }

    @Override
    public void setModel(CommonModel model) {
        this.mModels.add(model);
    }

    @Override
    public CommonModel getModel(int index) {
        return this.mModels.get(index);
    }

    @Override
    public CommonModel[] getModels() {
        CommonModel[] models=new CommonModel[mModels.size()];
        for(int i=0;i<this.mModels.size();i++){
            models[i]=this.mModels.get(i);
        }
        return models;
    }

    @Override
    public void removeAll() {
        this.mIndex=-1;
        this.mModels.clear();
    }

    @Override
    public void removeAt(int index) {
        this.mModels.remove(index);
    }

    @Override
    public void removeAt(int modelIndex, int mIndex) {
        this.mIndex=mIndex;
        removeAt(modelIndex);
    }

    @Override
    public int getmIndex(){
        return this.mIndex;
    }
}
