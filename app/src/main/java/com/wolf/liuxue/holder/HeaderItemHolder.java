package com.wolf.liuxue.holder;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BaseRecyclerHolder;
import com.wolf.liuxue.bean.HeaderItem;
import com.wolf.liuxue.databinding.HeaderItemBinding;

/**
 * Created by nanchaodong on 2017/10/16.
 */

public class HeaderItemHolder extends BaseRecyclerHolder<HeaderItem, HeaderItemBinding> {
    public HeaderItemHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void setUp(HeaderItem model, int position) {
        bindView.setHeaderItem(model);
        AnimationDrawable drawable = (AnimationDrawable) bindView.image.getDrawable();
        drawable.start();
    }
}
