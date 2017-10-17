package com.wolf.liuxue.holder;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BaseRecyclerHolder;
import com.wolf.liuxue.bean.NewsBtn;
import com.wolf.liuxue.databinding.NewsBtnItemBinding;
import com.wolf.liuxue.presenter.RecyclerManager;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class NewsBtnItemHolder extends BaseRecyclerHolder<NewsBtn, NewsBtnItemBinding> {
    private RecyclerManager recyclerManager;
    private GridLayoutManager manager;

    public NewsBtnItemHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView, adapter);
        manager = new GridLayoutManager(mCtx, 4);
        recyclerManager = new RecyclerManager(mCtx, bindView.recyclerView, manager);
    }

    @Override
    public void setUp(NewsBtn model, int position) {
        recyclerManager.LoadData(model.getNation());
    }
}
