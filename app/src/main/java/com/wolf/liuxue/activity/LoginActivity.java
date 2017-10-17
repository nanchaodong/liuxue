package com.wolf.liuxue.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.wolf.liuxue.R;
import com.wolf.liuxue.base.TopNoActivity;
import com.wolf.liuxue.databinding.ALoginBinding;
import com.wolf.liuxue.fragment.LoginFragment;
import com.wolf.liuxue.utils.CacheUtils;
import com.wolf.liuxue.utils.JumperManager;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class LoginActivity extends TopNoActivity<ALoginBinding> {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_login);
        if (CacheUtils.getIns().isLogin()){
            JumperManager.showMain(this);
            return;
        }
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.container,new LoginFragment()).commit();

    }
}