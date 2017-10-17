package com.wolf.liuxue.view;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

import com.wolf.liuxue.App;
import com.wolf.liuxue.R;
import com.wolf.liuxue.databinding.DialogItemBinding;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class ProgressDialog extends Dialog {
    private Context context;
    private DialogItemBinding bindView;

    public ProgressDialog(@NonNull Context context) {
        this(context, R.style.loadstyle);
        this.context = context;
    }

    public ProgressDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        bindView = DataBindingUtil.inflate(App.getInflater(), R.layout.dialog_item, null, false);
        setContentView(bindView.getRoot());
    }

}
