package com.wolf.liuxue.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.wolf.liuxue.R;
import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BindFragment;
import com.wolf.liuxue.bean.HeaderItem;
import com.wolf.liuxue.bean.TestBean;
import com.wolf.liuxue.databinding.FTabMineBinding;
import com.wolf.liuxue.databinding.HeaderItemBinding;
import com.wolf.liuxue.holder.HeaderItemHolder;
import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.view.RefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class TabMineFragment extends BindFragment<FTabMineBinding> {
    private static final String TAG = "TabMineFragment";
    @Override
    public int setLayout() {
        return R.layout.f_tab_mine;
    }

    private List<PresentImpl> list;
    private BaseRecyclerAdapter mAdapter;
    private GridLayoutManager manager;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showTitle(R.string.text_apply);
        list = new ArrayList<>();
        list.add(new HeaderItem());
        for (int i = 0; i < 10; i++) {
            list.add(new TestBean(i + "南朝东"));
        }
        mAdapter = new BaseRecyclerAdapter(getActivity());
        bindView.recyclerView.setAdapter(mAdapter);
        manager = new GridLayoutManager(getActivity(), 1);
        bindView.recyclerView.setManager(manager);
        mAdapter.addData(list);
        bindView.recyclerView.setListener(new RefreshRecyclerView.RefreshListener() {
            @Override
            public void onRefresh() {
                Log.i(TAG, "onRefresh: " + "aaaaaaaaaaaaaaaaa");
                Observable.timer(3000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Long>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                bindView.recyclerView.fail();
                            }

                            @Override
                            public void onNext(Long aLong) {
                                bindView.recyclerView.suc();
                            }
                        });
            }
        });
    }


}
