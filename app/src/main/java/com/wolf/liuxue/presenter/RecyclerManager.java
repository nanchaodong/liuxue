package com.wolf.liuxue.presenter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wolf.liuxue.base.BaseRecyclerAdapter;

import java.util.List;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class RecyclerManager {
    private Context context;
    private RecyclerView recyclerView;
    private BaseRecyclerAdapter mAdapter;
    private GridLayoutManager manager;

    public RecyclerManager(Context context, RecyclerView recyclerView, GridLayoutManager manager) {
        this.context = context;
        this.recyclerView = recyclerView;
        mAdapter = new BaseRecyclerAdapter(context);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(manager);

    }

    public RecyclerManager(Context context, RecyclerView recyclerView, int span) {
        this.context = context;
        this.recyclerView = recyclerView;
        manager = new GridLayoutManager(context, span);
        recyclerView.setLayoutManager(manager);
        mAdapter = new BaseRecyclerAdapter(context);
        recyclerView.setAdapter(mAdapter);


    }

    public <T extends PresentImpl> RecyclerManager LoadData(List<T> list) {
        mAdapter.addData(list);
        return this;
    }
}
