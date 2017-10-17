package com.wolf.liuxue.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wolf.liuxue.BR;
import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryImpl;

/**
 * Created by nanchaodong on 2017/10/16.
 */

public class HeaderItem extends BaseObservable implements PresentImpl {
    private String msg;
    private int status = Anim.PULL.ordinal();
    private boolean showAnim;


    public HeaderItem(String msg, int status, boolean showAnim) {
        this.msg = msg;
        this.status = status;
        this.showAnim = showAnim;
    }

    public HeaderItem() {
        msg = "下拉即可刷新...";
        showAnim = false;
        status = Anim.PULL.ordinal();
    }

    @Bindable
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        notifyPropertyChanged(BR.msg);
    }

    @Bindable
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        if (status == Anim.PULL.ordinal()) {
            msg = "下拉即可刷新...";
            showAnim = false;
        }
        if (status == Anim.REFRESH.ordinal()) {
            msg = "接受中...";
            showAnim = true;
        }
        if (status == Anim.RELEASE.ordinal()) {
            msg = "释放即可刷新...";
            showAnim = false;
        }
        if (status == Anim.COMPLETE.ordinal()) {
            msg = "数据加载成功...";
            showAnim = false;
        }
        if (status == Anim.FAIL.ordinal()){
            msg = "数据加载失败...";
            showAnim = false;
        }
        notifyPropertyChanged(BR.status);
        notifyPropertyChanged(BR.msg);
        notifyPropertyChanged(BR.showAnim);
    }

    @Bindable
    public boolean isShowAnim() {
        return showAnim;
    }

    public void setShowAnim(boolean showAnim) {
        this.showAnim = showAnim;

    }

    @Override
    public int itemType(TypeFactoryImpl typeFactory) {
        return typeFactory.type(this);
    }

    public enum Anim {
        PULL, RELEASE, REFRESH, COMPLETE,FAIL;
    }
}
