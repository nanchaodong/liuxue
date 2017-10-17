package com.wolf.liuxue.bean;

import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryImpl;

import java.util.List;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class TopAdvert implements PresentImpl {
    private List<TopAdv> topAdvs;

    public TopAdvert(List<TopAdv> topAdvs) {
        this.topAdvs = topAdvs;
    }

    public TopAdvert() {
    }

    public List<TopAdv> getTopAdvs() {
        return topAdvs;
    }

    public void setTopAdvs(List<TopAdv> topAdvs) {
        this.topAdvs = topAdvs;
    }

    @Override
    public String toString() {
        return "TopAdvert{" +
                "topAdvs=" + topAdvs +
                '}';
    }

    @Override
    public int itemType(TypeFactoryImpl typeFactory) {
        return typeFactory.type(this);
    }
}
