package com.wolf.liuxue.holder;

import android.view.View;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BaseRecyclerHolder;
import com.wolf.liuxue.bean.Footer;
import com.wolf.liuxue.databinding.FooterItemBinding;

/**
 * Created by nanchaodong on 2017/5/11.
 */

public class FooterHolder extends BaseRecyclerHolder<Footer,FooterItemBinding> {
    public FooterHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void setUp(Footer model, int position) {
        bindView.setFoot(model);
    }
}
