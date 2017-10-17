package com.wolf.liuxue.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.wolf.liuxue.R;
import com.wolf.liuxue.base.TopNoFragment;
import com.wolf.liuxue.bean.User;
import com.wolf.liuxue.databinding.FLoginBinding;
import com.wolf.liuxue.http.Api;
import com.wolf.liuxue.http.ApiBody;
import com.wolf.liuxue.http.RxHelper;
import com.wolf.liuxue.presenter.PresenterClick;
import com.wolf.liuxue.utils.CacheUtils;
import com.wolf.liuxue.utils.JumperManager;
import com.wolf.liuxue.utils.ViewUtils;

import rx.Subscriber;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class LoginFragment extends TopNoFragment<FLoginBinding> {
    private ApiBody apiBody;
    private static final String TAG = "LoginFragment";

    @Override
    public int setLayout() {
        return R.layout.f_login;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        User user = CacheUtils.getIns().getUser();
        if (user != null) {
            bindView.setUser(user);
        }
        bindView.setPresenter(click);
        apiBody = new ApiBody();


    }

    private PresenterClick click = new PresenterClick() {
        @Override
        public void click() {
            String phone = bindView.phoneEdit.getText().toString().trim();
            if (TextUtils.isEmpty(phone)) {
                ViewUtils.showMsg(getString(R.string.msg_phone_is_not_empty));
                return;
            }
            String pass = bindView.passwordEdit.getText().toString().trim();
            if (TextUtils.isEmpty(pass)) {
                ViewUtils.showMsg("密码不能为空");
                return;
            }
            showProgress();
            apiBody.addUserName(phone);
            apiBody.addPassWord(pass);
            Api.getDefault().login(apiBody.getBodyMap())
                    .compose(RxHelper.<User>handleResult())
                    .subscribe(new Subscriber<User>() {
                        @Override
                        public void onCompleted() {
                            dismissProgress();
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(User user) {
                            CacheUtils.getIns().setUser(user);
                            JumperManager.showMain(getActivity());

                        }
                    });
        }
    };
}
