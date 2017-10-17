package com.wolf.liuxue.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.wolf.liuxue.R;
import com.wolf.liuxue.base.BindActivity;
import com.wolf.liuxue.bean.New;
import com.wolf.liuxue.bean.NewGroup;
import com.wolf.liuxue.common.IntentKey;
import com.wolf.liuxue.databinding.ANewListBinding;
import com.wolf.liuxue.http.Api;
import com.wolf.liuxue.http.ApiBody;
import com.wolf.liuxue.http.HttpList;
import com.wolf.liuxue.http.HttpSubscriber;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class NewsListActivity extends BindActivity<ANewListBinding> implements HttpList.RefreshListListener {
    private static final String TAG = "NewsListActivity";
    private NewGroup newGroup;
    private ApiBody apiBody;
    private HttpList<New> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_new_list);
        showBackImage();
        newGroup = (NewGroup) getIntent().getSerializableExtra(IntentKey.KEY_NEWGROUP);
        showTitle(newGroup.getGroupName());
        apiBody = new ApiBody();
        apiBody.addCatId(newGroup.getCatId());
        apiBody.addStartIndex(0);
        apiBody.addPageSize(20);
        list = new HttpList<>(this,apiBody,bindView.recyclerView,bindView.swipe,1);
        list.setRefresh().setloadRefresh().setListener(this);
        list.loadTop(Api.getDefault().getNewsList(apiBody.getBodyMap()));
        Api.getDefault().getNewsLists(apiBody.getBodyMap()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new HttpSubscriber<ResponseBody>(){
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                super.onNext(responseBody);
                try {
                    String a = responseBody.string();
                    Log.i(TAG, "onNext: " + a);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void refreshTop() {
        list.loadTop(Api.getDefault().getNewsList(apiBody.getBodyMap()));

    }

    @Override
    public void refreshBottom() {
        list.loadBottom(Api.getDefault().getNewsList(apiBody.getBodyMap()));


    }
}
