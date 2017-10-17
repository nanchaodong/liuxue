package com.wolf.liuxue.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.wolf.liuxue.App;
import com.wolf.liuxue.R;
import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.bean.ExpressionBean;
import com.wolf.liuxue.databinding.RecyclerItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/5/16.
 */

public class EmojiPagerAdapter extends PagerAdapter {
    private Context mCtx;
    private List<List<ExpressionBean>> lists;
    private List<RecyclerItemBinding> dataBindings;


    public EmojiPagerAdapter(Context context) {
        this.mCtx = context;
        dataBindings = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            RecyclerItemBinding itemBinding = DataBindingUtil.inflate(App.getInflater(), R.layout.recycler_item, null, false);
            dataBindings.add(itemBinding);
        }
    }

    public void addData(List<List<ExpressionBean>> lists) {
        this.lists = lists;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        dataBindings.get(position).recyclerView.setLayoutManager(new GridLayoutManager(mCtx, 7) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        BaseRecyclerAdapter adapter = new BaseRecyclerAdapter(mCtx);
        dataBindings.get(position).recyclerView.setAdapter(adapter);
        adapter.addData(lists.get(position));
        container.addView(dataBindings.get(position).getRoot());
        return dataBindings.get(position).getRoot();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
