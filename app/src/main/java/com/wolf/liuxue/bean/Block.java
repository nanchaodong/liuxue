package com.wolf.liuxue.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wolf.liuxue.BR;
import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.PresenterClick;
import com.wolf.liuxue.presenter.TypeFactoryImpl;

/**
 * Created by nanchaodong on 2017/5/10.
 */

public class Block extends BaseObservable implements PresentImpl {
    private String blockId;
    private String title;
    private String headUrl;
    private int item;
    private boolean selected;

    @Bindable
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        notifyPropertyChanged(BR.selected);
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Block(String blockId, String title, String headUrl) {
        this.blockId = blockId;
        this.title = title;
        this.headUrl = headUrl;
    }

    public Block() {
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    @Override
    public String toString() {
        return "Block{" +
                "blockId='" + blockId + '\'' +
                ", title='" + title + '\'' +
                ", headUrl='" + headUrl + '\'' +
                '}';
    }

    @Override
    public int itemType(TypeFactoryImpl typeFactory) {
        return typeFactory.type(this);
    }
    public enum Type{
        COMMON,BOTTOM
    }
}
