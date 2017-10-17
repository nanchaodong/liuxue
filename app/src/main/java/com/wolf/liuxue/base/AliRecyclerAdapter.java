package com.wolf.liuxue.base;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/7/29.
 */

public class AliRecyclerAdapter extends BaseRecyclerAdapter {


    @NonNull
    protected VirtualLayoutManager mLayoutManager;

    public AliRecyclerAdapter(Context context,@NonNull VirtualLayoutManager layoutManager) {
        super(context);
        this.mLayoutManager = layoutManager;

    }


    public void setLayoutHelpers(List<LayoutHelper> layoutHelpers){
        this.mLayoutManager.setLayoutHelpers(layoutHelpers);
    }
    @NonNull
    public List<LayoutHelper> getLayoutHelpers(){
        return this.mLayoutManager.getLayoutHelpers();
    }



    public <T extends PresentImpl> void addData(List<T> list) {
        this.datas.clear();
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
    public int getItemCount() {
        List<LayoutHelper> helpers = getLayoutHelpers();
        if (helpers == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0, size = helpers.size(); i < size; i++) {
            count += helpers.get(i).getItemCount();
        }
        return count;
    }
}
