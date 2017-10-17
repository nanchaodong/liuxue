package com.wolf.liuxue.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.wolf.liuxue.R;
import com.wolf.liuxue.adapter.BottomCountryAdapter;
import com.wolf.liuxue.base.TopNoFragment;
import com.wolf.liuxue.bean.Block;
import com.wolf.liuxue.bean.EventMessage;
import com.wolf.liuxue.common.EventCode;
import com.wolf.liuxue.databinding.FBottonCountryBinding;
import com.wolf.liuxue.presenter.PresenterClick;
import com.wolf.liuxue.utils.CacheUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/5/16.
 */

public class BottomCountryFragment extends TopNoFragment<FBottonCountryBinding> {
    private BottomCountryAdapter countryAdapter;
    private List<Block> blocks = CacheUtils.getIns().getBlocks();
    private List<List<Block>> lists = new ArrayList<>();
    private List<TextView> textViews = new ArrayList<>();

    @Override
    public int setLayout() {
        return R.layout.f_botton_country;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindView.setPresenter(click);
        countryAdapter = new BottomCountryAdapter(getActivity());
        List<Block> first = blocks.subList(0, 9);
        List<Block> second = blocks.subList(9, blocks.size());
        for (Block block : first) {
            block.setItem(Block.Type.BOTTOM.ordinal());
        }
        for (Block block : second) {
            block.setItem(Block.Type.BOTTOM.ordinal());
        }
        lists.add(first);
        lists.add(second);

        bindView.viewpager.setOffscreenPageLimit(2);
        countryAdapter.addData(lists);

        bindView.viewpager.setAdapter(countryAdapter);
        bindView.viewpager.addOnPageChangeListener(changeListener);

        textViews.add(bindView.tab1);
        textViews.add(bindView.tab2);
        bindView.tab1.setSelected(true);
    }

    private ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            for (TextView textView : textViews) {
                textView.setSelected(false);
            }
            textViews.get(position).setSelected(true);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private PresenterClick click = new PresenterClick() {
        @Override
        public void click(int position) {
                bindView.viewpager.setCurrentItem(position,true);
        }
    };

    @Override
    protected void upData(EventMessage event) {
        if (event.getMsgId() == EventCode.BOTTOM_BLOCK_ITEM_CODE) {
            for (List<Block> list : lists) {
                for (Block block : list) {
                    block.setSelected(false);
                }
            }
        }
    }
}
