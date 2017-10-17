package com.wolf.liuxue.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by nanchaodong on 2017/5/10.
 */

public abstract class BaseRecyclerHolder<T, SV extends ViewDataBinding> extends RecyclerView.ViewHolder {
    protected SV bindView;
    protected BaseRecyclerAdapter baseRecyclerAdapter;
    protected Context mCtx;

    public BaseRecyclerHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView);
        baseRecyclerAdapter = adapter;
        bindView = DataBindingUtil.bind(itemView);
        bindView.executePendingBindings();
        mCtx = itemView.getContext();

    }

    public abstract void setUp(T model, int position);

    public SV getBindView() {
        return bindView;
    }
}
