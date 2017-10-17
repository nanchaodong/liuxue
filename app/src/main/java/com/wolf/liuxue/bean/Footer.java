package com.wolf.liuxue.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wolf.liuxue.BR;
import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryImpl;

/**
 * Created by nanchaodong on 2017/5/11.
 */

public class Footer extends BaseObservable implements PresentImpl {
    private int footId;//0 正在加载中...  1  数据请求失败  2 没有更多数据 3 隐藏脚布局
    private String msg;

    public Footer(int footId, String msg) {
        this.footId = footId;
        this.msg = msg;
    }

    public Footer() {
    }

    public Footer(int footId) {
        this.footId = footId;
    }

    @Bindable
    public int getFootId() {
        return footId;
    }

    public void setFootId(int footId) {
        this.footId = footId;
        notifyPropertyChanged(BR.footId);
        notifyPropertyChanged(BR.msg);
    }

    @Bindable
    public String getMsg() {
        switch (footId) {
            case 0:
                return "正在加载中...";
            case 1:
                return "~数据请求失败~";
            case 2:
                return "~没有更多数据~";
            default:
                return "";
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Footer{" +
                "footId=" + footId +
                ", msg='" + msg + '\'' +
                '}';
    }

    @Override
    public int itemType(TypeFactoryImpl typeFactory) {
        return typeFactory.type(this);
    }
}
