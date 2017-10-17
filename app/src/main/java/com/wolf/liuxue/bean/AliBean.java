package com.wolf.liuxue.bean;

import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryImpl;

/**
 * Created by nanchaodong on 2017/7/29.
 */

public class AliBean implements PresentImpl {

    private String title;

    public AliBean(String title) {
        this.title = title;
    }

    public AliBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int itemType(TypeFactoryImpl typeFactory) {
        return typeFactory.type(this);
    }
}
