package com.wolf.liuxue.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public abstract  class TopNoFragment<SV extends ViewDataBinding> extends BindFragment<SV> {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hideTop();
    }
    public void change(String blockId){

    }
}
