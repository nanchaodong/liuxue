package com.wolf.liuxue.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by nanchaodong on 2017/5/10.
 */

public class TabMainBean extends BaseObservable {

    private int imageId;
    private String topTitle;
    private String bottomTitle;

    public TabMainBean(int imageId, String topTitle, String bottomTitle) {
        this.imageId = imageId;
        this.topTitle = topTitle;
        this.bottomTitle = bottomTitle;
    }

    public TabMainBean() {
    }

    @Bindable
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Bindable
    public String getTopTitle() {
        return topTitle;
    }

    public void setTopTitle(String topTitle) {
        this.topTitle = topTitle;
    }

    @Bindable
    public String getBottomTitle() {
        return bottomTitle;
    }

    public void setBottomTitle(String bottomTitle) {
        this.bottomTitle = bottomTitle;
    }

    @Override
    public String toString() {
        return "TabMainBean{" +
                "imageId=" + imageId +
                ", topTitle='" + topTitle + '\'' +
                ", bottomTitle='" + bottomTitle + '\'' +
                '}';
    }
}
