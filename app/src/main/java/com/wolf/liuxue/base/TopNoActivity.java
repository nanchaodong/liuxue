package com.wolf.liuxue.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by nanchaodong on 2017/5/5.
 */

public class TopNoActivity<SV extends ViewDataBinding> extends BindActivity<SV> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideTop();
    }
}
