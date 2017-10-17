package com.wolf.liuxue.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.wolf.liuxue.App;
import com.wolf.liuxue.R;
import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.bean.Block;
import com.wolf.liuxue.databinding.RecyclerItemBinding;
import com.wolf.liuxue.presenter.PresentImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/5/16.
 */

public class BottomCountryAdapter extends PagerAdapter {
    private List<List<Block>> lists;
    private List<RecyclerItemBinding> dataBindings;
    private List<BaseRecyclerAdapter> adapters;
    private Context mCtx;

    public BottomCountryAdapter(Context context) {
        this.mCtx = context;
        dataBindings = new ArrayList<>();
        adapters = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            RecyclerItemBinding itemBinding = DataBindingUtil.inflate(App.getInflater(), R.layout.recycler_item, null, false);
            BaseRecyclerAdapter adapter = new BaseRecyclerAdapter(mCtx);
            dataBindings.add(itemBinding);
            adapters.add(adapter);
        }

    }

    public void addData(List<List<Block>> lists) {
        this.lists = lists;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataBindings.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        dataBindings.get(position).recyclerView.setAdapter(adapters.get(position));
        dataBindings.get(position).recyclerView.setLayoutManager(new GridLayoutManager(mCtx, 3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        adapters.get(position).addData(lists.get(position));
        container.addView(dataBindings.get(position).getRoot());
        return dataBindings.get(position).getRoot();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
