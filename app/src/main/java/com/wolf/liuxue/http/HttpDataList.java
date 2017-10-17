package com.wolf.liuxue.http;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.wolf.liuxue.adapter.FooterRecyclerAdapter;
import com.wolf.liuxue.bean.JResult;
import com.wolf.liuxue.presenter.PresentImpl;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class HttpDataList<T> {
    private static final String TAG = "HttpDataList";
    private Context context;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private int span;
    private FooterRecyclerAdapter mAdapter;
    private GridLayoutManager manager;


    public HttpDataList(Context context, RecyclerView recyclerView, SwipeRefreshLayout refreshLayout, int span) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.refreshLayout = refreshLayout;
        this.span = span;
        mAdapter = new FooterRecyclerAdapter(context);
        recyclerView.setAdapter(mAdapter);
        manager = new GridLayoutManager(context, span);
        recyclerView.setLayoutManager(manager);
        refreshLayout.setEnabled(false);

    }

    public HttpDataList setRefresh() {
        refreshLayout.setEnabled(true);
        refreshLayout.setOnRefreshListener(refreshListener);
        return this;
    }

    public HttpDataList setTopListener(TopRefreshListener listener) {
        this.listener = listener;
        return this;

    }
    public FooterRecyclerAdapter getAdapter(){
        return mAdapter;
    }

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            if (listener != null) {
                listener.topRefresh();
            }
        }
    };

    public void loadTop(Observable<JResult<T>> observable) {
        refreshLayout.setRefreshing(true);

        observable.compose(RxHelper.<T>handleResult()).subscribe(new Subscriber<T>() {
            @Override
            public void onCompleted() {
                refreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {
                refreshLayout.setRefreshing(false);
                Log.i(TAG, "onError: " + e.getMessage());

            }

            @Override
            public void onNext(T t) {
                if (listener != null){
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
