package com.wolf.liuxue.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.wolf.liuxue.R;
import com.wolf.liuxue.base.BindFragment;
import com.wolf.liuxue.base.TopNoActivity;
import com.wolf.liuxue.bean.Config;
import com.wolf.liuxue.databinding.ActivityMainBinding;
import com.wolf.liuxue.fragment.TabClassFragment;
import com.wolf.liuxue.fragment.TabMainFragment;
import com.wolf.liuxue.fragment.TabMineFragment;
import com.wolf.liuxue.fragment.TabRecommendFragment;
import com.wolf.liuxue.fragment.TabToolFragment;
import com.wolf.liuxue.http.Api;
import com.wolf.liuxue.http.ApiBody;
import com.wolf.liuxue.http.HttpSubscriber;
import com.wolf.liuxue.http.RxHelper;
import com.wolf.liuxue.utils.CacheUtils;
import com.wolf.liuxue.view.TabView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

public class MainActivity extends TopNoActivity<ActivityMainBinding> {
    private ApiBody configBody;
    private List<TabView> tabViews = new ArrayList<>();
    private List<BindFragment> bindFragments = new ArrayList<>();
    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getConfig();
        initBottom();

    }

    private void initBottom() {
        manager = getSupportFragmentManager();
        tabViews.add(bindView.tabView0);
        tabViews.add(bindView.tabView1);
        tabViews.add(bindView.tabView2);
        tabViews.add(bindView.tabView3);
        tabViews.add(bindView.tabView4);
        bindFragments.add(new TabMainFragment());
        bindFragments.add(new TabRecommendFragment());
        bindFragments.add(new TabClassFragment());
        bindFragments.add(new TabToolFragment());
        bindFragments.add(new TabMineFragment());
        for (TabView tabView : tabViews) {
            tabView.setBindFragment(bindFragments);
            tabView.setManager(manager);
            tabView.setTabViews(tabViews);
            tabView.setCurrentFragment(bindFragments.get(0));

        }
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container,bindFragments.get(0)).show(bindFragments.get(0)).commit();

    }

    private void getConfig() {
        configBody = new ApiBody();
        Api.getDefault().getConfig(configBody.getBodyMap())
                .compose(RxHelper.<List<Config>>handleResult())
                .flatMap(new Func1<List<Config>, Observable<Config>>() {
                    @Override
                    public Observable<Config> call(List<Config> configs) {
                        return Observable.from(configs);
                    }
                }).subscribe(new HttpSubscriber<Config>() {
            @Override
            public void onNext(Config config) {
                CacheUtils.getIns().setConfig(config);

            }
        });
    }
}
