package com.wolf.liuxue.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wolf.liuxue.R;
import com.wolf.liuxue.adapter.EmojiPagerAdapter;
import com.wolf.liuxue.base.TopNoFragment;
import com.wolf.liuxue.bean.ExpressionBean;
import com.wolf.liuxue.common.Emoji;
import com.wolf.liuxue.databinding.FEmojiBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/5/16.
 */

public class EmojiFragment extends TopNoFragment<FEmojiBinding> {
    private List<List<ExpressionBean>> lists = new ArrayList<>();
    private EmojiPagerAdapter mAdapter;

    @Override
    public int setLayout() {
        return R.layout.f_emoji;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lists.add(Emoji.getFirstPageExpressions());
        lists.add(Emoji.getSecondPageExpressions());
        mAdapter = new EmojiPagerAdapter(getActivity());
        mAdapter.addData(lists);
        bindView.viewpager.setAdapter(mAdapter);


    }
}
