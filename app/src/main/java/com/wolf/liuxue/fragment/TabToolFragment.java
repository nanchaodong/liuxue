package com.wolf.liuxue.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wolf.liuxue.R;
import com.wolf.liuxue.base.BindFragment;
import com.wolf.liuxue.databinding.FTabToolBinding;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class TabToolFragment extends BindFragment<FTabToolBinding> {
    @Override
    public int setLayout() {
        return R.layout.f_tab_tool;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showTitle(R.string.text_tools);
    }
}
