package com.wolf.liuxue.bean;

import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryImpl;

/**
 * Created by nanchaodong on 2017/10/16.
 */

public class TestBean implements PresentImpl{
    private String title;

    public TestBean(String title) {
        this.title = title;
    }

    public TestBean() {
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
