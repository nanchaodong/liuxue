package com.wolf.liuxue.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.wolf.liuxue.R;
import com.wolf.liuxue.base.AliRecyclerAdapter;
import com.wolf.liuxue.base.BindFragment;
import com.wolf.liuxue.bean.Article;
import com.wolf.liuxue.databinding.FTabClassBinding;
import com.wolf.liuxue.http.Api;
import com.wolf.liuxue.http.ApiBody;
import com.wolf.liuxue.http.RxHelper;

import java.util.LinkedList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class TabClassFragment extends BindFragment<FTabClassBinding> {
    private AliRecyclerAdapter recyclerAdapter;
    private VirtualLayoutManager vManager;
    private List<LayoutHelper> layoutHelpers;
    private GridLayoutHelper helper;
    @Override
    public int setLayout() {
        return R.layout.f_tab_class;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showTitle(R.string.text_class);
        vManager = new VirtualLayoutManager(getActivity());
        recyclerAdapter = new AliRecyclerAdapter(getActivity(), vManager);
        bindView.recyclerView.setAdapter(recyclerAdapter);
        bindView.recyclerView.setLayoutManager(vManager);
        layoutHelpers = new LinkedList<>();
        helper = new GridLayoutHelper(4);
        layoutHelpers.add(helper);
        vManager.setLayoutHelpers(layoutHelpers);

    }
}
