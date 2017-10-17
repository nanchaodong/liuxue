package com.wolf.liuxue.base;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.wolf.liuxue.bean.HeaderItem;
import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/5/10.
 */

public class BaseRecyclerAdapter extends RecyclerView.Adapter<BaseRecyclerHolder> {
    protected List<PresentImpl> datas;
    protected Context mCtx;
    private TypeFactoryList factoryList;
    protected HeaderItem headerItem;

    public BaseRecyclerAdapter(Context context) {
        this.mCtx = context;
        factoryList = new TypeFactoryList();
        datas = new ArrayList<>();
        headerItem = new HeaderItem();
    }

    public <T extends PresentImpl> void addData(List<T> list) {
        this.datas.clear();
        this.datas.add(headerItem);
        this.datas.addAll(list);
        notifyDataSetChanged();
    }

    public <T extends PresentImpl> void addData(T t) {
        this.datas.add(t);
        notifyItemInserted(this.datas.size() - 1);
    }


    public void clear() {
        this.datas.clear();
        notifyDataSetChanged();
    }

    public <T extends PresentImpl> void addMoreData(List<T> list) {
        int startIndex = this.datas.size();
        this.datas.addAll(list);
        notifyItemRangeChanged(startIndex, datas.size() - 1);
    }

    @Override
    public BaseRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mCtx, viewType, null);
        return factoryList.create(viewType, view, this);
    }

    @Override
    public void onBindViewHolder(BaseRecyclerHolder holder, int position) {
        holder.setUp(datas.get(position), position);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).itemType(factoryList);
    }

    public HeaderItem getHeaderBean() {
        PresentImpl present = datas.get(0);
        if (present instanceof HeaderItem) {
            return (HeaderItem) present;
        }
        return null;
    }
}
