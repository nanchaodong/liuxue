package com.wolf.liuxue.http;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wolf.liuxue.adapter.FooterRecyclerAdapter;
import com.wolf.liuxue.bean.JResult;
import com.wolf.liuxue.bean.PagerList;
import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.view.RefreshRecyclerView;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by nanchaodong on 2017/5/11.
 */

public class HttpList<T extends PresentImpl> {
    private static final String TAG = "HttpList";
    private ApiBody apiBody;
    private RefreshRecyclerView rView;
    private Context context;
    private FooterRecyclerAdapter mAdapter;
    private GridLayoutManager manager;
    private boolean loading;

    public HttpList(Context context, ApiBody apiBody,
                    RecyclerView recyclerView,
                    int span) {
        this.apiBody = apiBody;
        this.rView = (RefreshRecyclerView) recyclerView;
        this.context = context;
        this.mAdapter = new FooterRecyclerAdapter(context);
        this.rView.setAdapter(this.mAdapter);
        manager = new GridLayoutManager(context, span);
        rView.setCanRfresh(false);
        rView.setManager(manager);
    }

    public void clear() {
        mAdapter.clear();
    }

    public void loadTop(Observable<JResult<PagerList<List<T>>>> observable) {
        rView.setCanRfresh(true);
        observable.compose(RxHelper.<T>handleList()).subscribe(new Subscriber<List<T>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                rView.fail();

            }

            @Override
            public void onNext(List<T> list) {
                rView.suc();
                mAdapter.addData(list);
                apiBody.addStartIndex(list.size());
            }
        });
    }

    public void loadBottom(Observable<JResult<PagerList<List<T>>>> observable) {
        observable.compose(RxHelper.<T>handleList()).subscribe(new Subscriber<List<T>>() {
            @Override
            public void onCompleted() {
                loading = false;
                mAdapter.setFooter(3);

            }

            @Override
            public void onError(Throwable e) {
                rView.fail();
                loading = false;
                mAdapter.setFooter(1);

            }

            @Override
            public void onNext(List<T> list) {
                rView.suc();
                mAdapter.addMoreData(list);
                apiBody.addStartIndex(mAdapter.getSize());

            }
        });
    }


    public HttpList setRefresh() {
        rView.setCanRfresh(true);
        rView.setListener(refreshListener);
        return this;
    }

    private RefreshRecyclerView.RefreshListener refreshListener = new RefreshRecyclerView.RefreshListener() {
        @Override
        public void onRefresh() {
            if (listener != null) {
                apiBody.addStartIndex(0);
                listener.refreshTop();
            }
        }
    };


    public HttpList setloadRefresh() {
        rView.addOnScrollListener(scrollListener);
        return this;
    }

    private RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int total = manager.getItemCount();
            int lastVisibleItem = manager.findLastVisibleItemPosition();
            if (dy > 0) {
                if (total > 0 && lastVisibleItem >= total - 2) {
                    if (listener != null) {
                        if (!loading) {
                            loading = true;
                            mAdapter.setFooter(0);
                            listener.refreshBottom();
                        }
                    }
                }
            }
        }
    };

    public interface RefreshListListener {
        void refreshTop();

        void refreshBottom();
    }

    private RefreshListListener listener;

    public void setListener(RefreshListListener listener) {
        this.listener = listener;
    }

}
