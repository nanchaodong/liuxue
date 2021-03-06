package com.wolf.liuxue.holder;

import android.view.View;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BaseRecyclerHolder;
import com.wolf.liuxue.bean.New;
import com.wolf.liuxue.databinding.NewGroupChildTwoItemBinding;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class NewGroupChildTwoItemHolder extends BaseRecyclerHolder<New, NewGroupChildTwoItemBinding> {

    public NewGroupChildTwoItemHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void setUp(New model, int position) {
        bindView.setNews(model);

    }
}
