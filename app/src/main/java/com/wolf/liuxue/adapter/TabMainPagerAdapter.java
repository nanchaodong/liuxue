package com.wolf.liuxue.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wolf.liuxue.base.BindFragment;

import java.util.List;

/**
 * Created by nanchaodong on 2017/5/10.
 */

public class TabMainPagerAdapter extends FragmentPagerAdapter {
    private List<BindFragment> list;

    public TabMainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragments(List<BindFragment> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
