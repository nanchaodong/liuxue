package com.wolf.liuxue.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.wolf.liuxue.R;
import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.TopNoFragment;
import com.wolf.liuxue.bean.Article;
import com.wolf.liuxue.bean.JResult;
import com.wolf.liuxue.bean.PagerList;
import com.wolf.liuxue.databinding.FTabNewBinding;
import com.wolf.liuxue.http.Api;
import com.wolf.liuxue.http.ApiBody;
import com.wolf.liuxue.http.HttpList;
import com.wolf.liuxue.http.RxHelper;
import com.wolf.liuxue.presenter.PresentImpl;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nanchaodong on 2017/5/10.
 */

public class TabNewFragment extends TopNoFragment<FTabNewBinding> implements HttpList.RefreshListListener {
    private ApiBody apiBody;
    private HttpList<Article> httpList;

    @Override
    public int setLayout() {
        return R.layout.f_tab_new;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();

    }

    private void initData() {
        apiBody = new ApiBody();
        apiBody.addQsid(213);
        apiBody.addSearchType(1);
        apiBody.addStartIndex(0);
        apiBody.addPageSize(20);
        apiBody.addTimeOrder();
        httpList = new HttpList<>(getActivity(), apiBody, bindView.recyclerView, bindView.swipe, 1)
                .setRefresh()
                .setloadRefresh();
        httpList.setListener(this);
        httpList.loadTop(Api.getDefault().getNewArticles(apiBody.getBodyMap()));
    }

    @Override
    public void refreshTop() {
        httpList.loadTop(Api.getDefault().getNewArticles(apiBody.getBodyMap()));

    }

    @Override
    public void refreshBottom() {
        httpList.loadBottom(Api.getDefault().getNewArticles(apiBody.getBodyMap()));

    }
    @Override
    public void change(String blockId) {
        httpList.clear();
        apiBody.addQsid(blockId);
        httpList.loadTop(Api.getDefault().getNewArticles(apiBody.getBodyMap()));
    }
}
