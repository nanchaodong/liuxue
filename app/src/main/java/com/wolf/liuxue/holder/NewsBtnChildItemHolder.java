package com.wolf.liuxue.holder;

import android.view.View;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BaseRecyclerHolder;
import com.wolf.liuxue.bean.NewBtn;
import com.wolf.liuxue.databinding.NewsBtnChildItemBinding;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class NewsBtnChildItemHolder extends BaseRecyclerHolder<NewBtn, NewsBtnChildItemBinding> {
    public NewsBtnChildItemHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void setUp(NewBtn model, int position) {
        bindView.setNation(model);
    }
}
