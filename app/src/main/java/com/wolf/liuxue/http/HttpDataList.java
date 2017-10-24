package com.wolf.liuxue.http;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.wolf.liuxue.adapter.FooterRecyclerAdapter;
import com.wolf.liuxue.bean.JResult;
import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.view.RefreshRecyclerView;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class HttpDataList<T> {
    private static final String TAG = "HttpDataList";
    private Context context;
    private RefreshRecyclerView rView;
    private int span;
    private FooterRecyclerAdapter mAdapter;
    private GridLayoutManager manager;


    public HttpDataList(Context context, RecyclerView recyclerView, int span) {
        this.context = context;
        this.rView = (RefreshRecyclerView) recyclerView;
        this.span = span;
        mAdapter = new FooterRecyclerAdapter(context);
        recyclerView.setAdapter(mAdapter);
        manager = new GridLayoutManager(context, span);
        rView.setManager(manager);
        rView.setCanRfresh(false);

    }

    public HttpDataList setRefresh() {
        rView.setCanRfresh(true);
        rView.setListener(refreshListener);
        return this;
    }

    public HttpDataList setTopListener(TopRefreshListener listener) {
        this.listener = listener;
        return this;

    }

    public FooterRecyclerAdapter getAdapter() {
        return mAdapter;
    }

    private RefreshRecyclerView.RefreshListener refreshListener = new RefreshRecyclerView.RefreshListener() {
        @Override
        public void onRefresh() {
            if (listener != null) {
                listener.topRefresh();
            }
        }
    };


    public void loadTop(Observable<JResult<T>> observable) {
        rView.setCanRfresh(true);

        observable.compose(RxHelper.<T>handleResult()).subscribe(new Subscriber<T>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                rView.fail();
                Log.i(TAG, "onError: " + e.getMessage());

            }

            @Override
            public void onNext(T t) {
                rView.suc();
                if (listener != null) {
                    listener.result(t);
                }

            }
        });
    }

    public interface TopRefreshListener<T> {
        void topRefresh();

        void result(T t);
    }

    private TopRefreshListener listener;

    public void setListener(TopRefreshListener listener) {
        this.listener = listener;
    }
}
