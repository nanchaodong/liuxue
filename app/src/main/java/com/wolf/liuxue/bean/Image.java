package com.wolf.liuxue.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wolf.liuxue.BR;
import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryImpl;

/**
 * Created by nanchaodong on 2017/5/17.
 */

public class Image extends BaseObservable implements PresentImpl {
    private String path;
    private String name;
    private long time;
    private boolean select;

    public Image(String path, String name, long time) {
        this.path = path;
        this.name = name;
        this.time = time;
    }

    public Image() {
    }

    @Bindable
    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
        notifyPropertyChanged(BR.select);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public int itemType(TypeFactoryImpl typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Image other = (Image) obj;
            return this.path.equalsIgnoreCase(other.path);
        } catch (Exception e) {

        }
        return super.equals(obj);
    }
}
