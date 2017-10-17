package com.wolf.liuxue.holder;

import android.view.View;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BaseRecyclerHolder;
import com.wolf.liuxue.bean.TestBean;
import com.wolf.liuxue.databinding.TestBeanItemBinding;

/**
 * Created by nanchaodong on 2017/10/16.
 */

public class TestBeanHolder extends BaseRecyclerHolder<TestBean, TestBeanItemBinding> {
    public TestBeanHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void setUp(TestBean model, int position) {
        bindView.setTestBean(model);
    }
}
