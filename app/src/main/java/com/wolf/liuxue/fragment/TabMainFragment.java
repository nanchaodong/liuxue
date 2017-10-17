package com.wolf.liuxue.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wolf.liuxue.R;
import com.wolf.liuxue.adapter.TabMainPagerAdapter;
import com.wolf.liuxue.base.BindFragment;
import com.wolf.liuxue.base.TopNoFragment;
import com.wolf.liuxue.bean.Block;
import com.wolf.liuxue.bean.TabMainBean;
import com.wolf.liuxue.databinding.FMainBinding;
import com.wolf.liuxue.presenter.PresenterClick;
import com.wolf.liuxue.utils.CacheUtils;
import com.wolf.liuxue.utils.JumperManager;
import com.wolf.liuxue.view.BlockFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class TabMainFragment extends BindFragment<FMainBinding> {
    private static final String TAG = "TabMainFragment";
    private List<TextView> tabs;
    private List<BindFragment> bindFragments = new ArrayList<>();
    private TabMainPagerAdapter tabMainPagerAdapter;
    private List<TabMainBean> tabMainBeens = new ArrayList<>();
    private BlockFragment blockFragment;

    @Override
    public int setLayout() {
        return R.layout.f_main;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (blockFragment == null) {
            blockFragment = new BlockFragment();
            blockFragment.setListener(itemClickListener);
        }
        tabs = getTabs();
        tabMainBeens.add(new TabMainBean(R.mipmap.icon_ask_student, "联系顾问", "1对1专属留学规划"));
        tabMainBeens.add(new TabMainBean(R.mipmap.icon_ask_teacher, "我要提问", "专业留学问答服务"));
        bindView.setList(tabMainBeens);
        bindView.setPresenter(click);
        bindFragments.add(new TabNewFragment());
        bindFragments.add(new TabHotFragment());
        tabMainPagerAdapter = new TabMainPagerAdapter(getChildFragmentManager());
        tabMainPagerAdapter.addFragments(bindFragments);
        bindView.viewpager.setAdapter(tabMainPagerAdapter);
        bindView.viewpager.addOnPageChangeListener(changeListener);
        for (TextView tab : tabs) {
            tab.setOnClickListener(listener);
        }
        if (CacheUtils.getIns().getBlocks() != null) {
            Picasso.with(getActivity())
                    .load(CacheUtils.getIns().getBlocks().get(0).getHeadUrl())
                    .placeholder(R.mipmap.ic_loading)
                    .error(R.mipmap.ic_loading)
                    .into(topLeftImage());
        }

        topLeftImage().setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tab0:
                    bindView.viewpager.setCurrentItem(0);
                    break;
                case R.id.tab1:
                    bindView.viewpager.setCurrentItem(1);
                    break;
                case R.id.left_icon:

                    blockFragment.show(getFragmentManager(), "ss");
                    break;

            }
        }
    };
    private ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            for (TextView tab : tabs) {
                tab.setSelected(false);
            }
            tabs.get(position).setSelected(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private PresenterClick click = new PresenterClick() {
        @Override
        public void click(int position) {
            switch (position) {
                case 0:

                    break;
                case 1:
                    JumperManager.showPublishActivity(getActivity());
                    break;
            }
        }
    };
    private BlockFragment.BlockItemClickListener itemClickListener = new BlockFragment.BlockItemClickListener() {
        @Override
        public void clickBlockItem(Block block) {
            Picasso.with(getActivity())
                    .load(block.getHeadUrl())
                    .placeholder(R.mipmap.ic_loading)
                    .error(R.mipmap.ic_loading)
                    .into(topLeftImage());
            for (BindFragment bindFragment : bindFragments) {
                ((TopNoFragment) bindFragment).change(block.getBlockId());
            }

        }
    };
}
