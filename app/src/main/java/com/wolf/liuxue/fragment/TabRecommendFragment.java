package com.wolf.liuxue.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.wolf.liuxue.R;
import com.wolf.liuxue.base.BindFragment;
import com.wolf.liuxue.bean.NewBtn;
import com.wolf.liuxue.bean.NewList;
import com.wolf.liuxue.bean.NewsBtn;
import com.wolf.liuxue.bean.TopAdv;
import com.wolf.liuxue.bean.TopAdvert;
import com.wolf.liuxue.databinding.FTabRecommendBinding;
import com.wolf.liuxue.http.Api;
import com.wolf.liuxue.http.ApiBody;
import com.wolf.liuxue.http.HttpDataList;
import com.wolf.liuxue.http.RxHelper;
import com.wolf.liuxue.presenter.PresentImpl;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class TabRecommendFragment extends BindFragment<FTabRecommendBinding> implements HttpDataList.TopRefreshListener<NewList> {
    private static final String TAG = "TabRecommendFragment";
    private ApiBody apiBody;
    private HttpDataList<NewList> httpDataList;

    @Override
    public int setLayout() {
        return R.layout.f_tab_recommend;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showTitle(R.string.text_recommed);
        apiBody = new ApiBody();
        httpDataList = new HttpDataList<>(getActivity(), bindView.recyclerView, 1)
                .setRefresh()
                .setTopListener(this);
        httpDataList.loadTop(Api.getDefault().getNewsHome(apiBody.getBodyMap()));

    }

    @Override
    public void topRefresh() {
        httpDataList.loadTop(Api.getDefault().getNewsHome(apiBody.getBodyMap()));

    }

    @Override
    public void result(NewList newList) {
        Log.i(TAG, "result: " + newList.toString());
        List<PresentImpl> list = new ArrayList<>();
        List<TopAdv> topAdvs = newList.getTopAdvs();
        if (topAdvs != null && topAdvs.size() > 0) {
            TopAdvert topAdvert = new TopAdvert(topAdvs);
            list.add(topAdvert);
        }
        List<NewBtn> nation = newList.getNation();
        if (nation != null && nation.size() > 0) {
            NewsBtn newsBtn = new NewsBtn(nation);
            list.add(newsBtn);
        }
        if (newList.getNewsGroup() != null && newList.getNewsGroup().size() > 0) {
            list.addAll(newList.getNewsGroup());
        }
        httpDataList.getAdapter().addData(list);

    }
}
