package com.wolf.liuxue.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wolf.liuxue.R;
import com.wolf.liuxue.bean.EventMessage;
import com.wolf.liuxue.databinding.FBaseBinding;
import com.wolf.liuxue.utils.EventPush;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public abstract class BindFragment<SV extends ViewDataBinding> extends Fragment {
    protected FBaseBinding fBaseBinding;
    protected SV bindView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventPush.ins().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fBaseBinding = DataBindingUtil.inflate(inflater, R.layout.f_base, null, false);
        bindView = DataBindingUtil.inflate(inflater, setLayout(), fBaseBinding.content, true);
        setBelow();
        return fBaseBinding.getRoot();
    }

    public abstract int setLayout();

    public void setBelow() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fBaseBinding.body.getLayoutParams();
        layoutParams.addRule(RelativeLayout.BELOW, R.id.topView);
    }

    protected void showTop() {
        fBaseBinding.topView.setVisibility(View.VISIBLE);
    }

    protected void showTitle(Object o) {
        showTop();
        String title = "";
        if (o instanceof String) {
            title = (String) o;
        } else if (o instanceof Integer) {
            title = getString((Integer) o);
        }
        fBaseBinding.topView.setTitle(title);
    }

    protected void hideTop() {
        fBaseBinding.topView.setVisibility(View.GONE);

    }

    protected void showProgress() {
        BindActivity activity = (BindActivity) getActivity();
        activity.showProgress();
    }

    protected void dismissProgress() {
        BindActivity activity = (BindActivity) getActivity();
        activity.dismissProgress();
    }

    protected List<TextView> getTabs() {
        fBaseBinding.topView.showTabs();
        return fBaseBinding.topView.getTabs();
    }

    protected ImageView topLeftImage() {
        return fBaseBinding.topView.leftImage();
    }

    protected ImageView topRightImage() {
        return fBaseBinding.topView.rightImage();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventPush.ins().unRegister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(EventMessage event) {
        upData(event);
    }

    protected void upData(EventMessage event) {

    }

}
