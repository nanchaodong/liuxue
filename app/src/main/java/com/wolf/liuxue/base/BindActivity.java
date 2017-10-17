package com.wolf.liuxue.base;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.wolf.liuxue.App;
import com.wolf.liuxue.R;
import com.wolf.liuxue.bean.EventMessage;
import com.wolf.liuxue.databinding.ABaseBinding;
import com.wolf.liuxue.utils.EventPush;
import com.wolf.liuxue.view.ProgressDialog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by nanchaodong on 2017/5/5.
 */

public class BindActivity<SV extends ViewDataBinding> extends AppCompatActivity {
    protected ABaseBinding aBaseBinding;
    protected SV bindView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventPush.ins().register(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        aBaseBinding = DataBindingUtil.inflate(App.getInflater(), R.layout.a_base, null, false);
        setBelow();

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        bindView = DataBindingUtil.inflate(App.getInflater(), layoutResID, aBaseBinding.content, true);
        getWindow().setContentView(aBaseBinding.getRoot());
    }

    public void setBelow() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aBaseBinding.body.getLayoutParams();
        layoutParams.addRule(RelativeLayout.BELOW, R.id.topView);
    }

    protected void showTop() {
        aBaseBinding.topView.setVisibility(View.VISIBLE);
    }

    protected BindActivity showTitle(Object o) {
        showTop();
        String title = "";
        if (o instanceof String) {
            title = (String) o;
        } else if (o instanceof Integer) {
            title = getString((Integer) o);
        }
        aBaseBinding.topView.setTitle(title);
        return this;
    }

    protected void hideTop() {
        aBaseBinding.topView.setVisibility(View.GONE);

    }

    public void showProgress() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.show();
    }

    public void dismissProgress() {
        if (progressDialog == null) {
            return;
        }
        progressDialog.dismiss();
    }

    public BindActivity showBackImage() {
        aBaseBinding.topView.showBackImage().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        return this;
    }

    public BindActivity showRightText(Object text) {
        String title = "";
        if (text instanceof String) {
            title = (String) text;
        } else if (text instanceof Integer) {
            title = getString((Integer) text);
        }
        aBaseBinding.topView.rightText().setText(title);
        aBaseBinding.topView.rightText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RightTextButtonClick();
            }
        });
        return this;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventPush.ins().unRegister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(EventMessage event) {
        update(event);
    }

    protected void update(EventMessage message) {

    }

    protected void RightTextButtonClick() {

    }

    protected boolean requestPermission() {
        int check = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (check != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    100);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100:
                readExternalStoreage();
                break;
        }
    }

    protected void readExternalStoreage() {

    }
}
