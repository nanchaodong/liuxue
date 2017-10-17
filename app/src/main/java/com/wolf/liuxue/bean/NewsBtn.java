package com.wolf.liuxue.bean;

import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryImpl;

import java.util.List;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class NewsBtn implements PresentImpl{
    private List<NewBtn> nation;

    public NewsBtn(List<NewBtn> nation) {
        this.nation = nation;
    }

    public NewsBtn() {
    }

    public List<NewBtn> getNation() {
        return nation;
    }

    public void setNation(List<NewBtn> nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "NewsBtn{" +
                "nation=" + nation +
                '}';
    }

    @Override
    public int itemType(TypeFactoryImpl typeFactory) {
        return typeFactory.type(this);
    }
}
