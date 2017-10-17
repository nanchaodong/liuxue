package com.wolf.liuxue.activity;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.wolf.liuxue.R;
import com.wolf.liuxue.base.BindActivity;
import com.wolf.liuxue.bean.Block;
import com.wolf.liuxue.bean.EventMessage;
import com.wolf.liuxue.common.EventCode;
import com.wolf.liuxue.databinding.APublishBinding;
import com.wolf.liuxue.fragment.BottomCountryFragment;
import com.wolf.liuxue.fragment.EmojiFragment;
import com.wolf.liuxue.http.ApiBody;
import com.wolf.liuxue.presenter.PresenterClick;
import com.wolf.liuxue.utils.CacheUtils;
import com.wolf.liuxue.utils.JumperManager;
import com.wolf.liuxue.utils.ViewUtils;

/**
 * Created by nanchaodong on 2017/5/16.
 */

public class PublishActivity extends BindActivity<APublishBinding> {
    private BottomCountryFragment countryFragment;
    private EmojiFragment emojiFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private ApiBody apiBody;
    private Block block;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_publish);
        showTitle(getString(R.string.text_publish))
                .showBackImage()
                .showRightText(R.string.text_publish_article);
        bindView.setPresenter(click);
        countryFragment = new BottomCountryFragment();
        emojiFragment = new EmojiFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.emojlayout, countryFragment).add(R.id.emojlayout, emojiFragment).commit();
        bindView.editText.setOnClickListener(listener);
        apiBody = new ApiBody();
        bindView.editText.setOnKeyListener(keyListener);

    }

    @Override
    protected void onResume() {
        super.onResume();
        showNormalTab();
        showBottom(false);
    }

    private View.OnKeyListener keyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_DEL) {
                ViewUtils.deleteText(bindView.editText);
                return true;
            }
            return false;
        }
    };

    @Override
    protected void RightTextButtonClick() {
        if (TextUtils.isEmpty(bindView.editText.getText().toString().trim())) {
            ViewUtils.showMsg(R.string.text_please_input_your_question);
            return;
        }
        if (block == null) {
            if (!countryFragment.isAdded()) {
                transaction = manager.beginTransaction();
                transaction.add(R.id.emojlayout, countryFragment).show(countryFragment).commit();
            }
            bindView.imageCountry.setSelected(true);
            ViewUtils.showMsg(R.string.text_please_choose_block);
            showBottom(true);
            return;
        }

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showNormalTab();
            showBottom(false);
        }
    };

    private PresenterClick click = new PresenterClick() {
        @Override
        public void click(int position) {
            showNormalTab();
            bindView.bottomCotrol.getChildAt(position).setSelected(true);
            switch (position) {
                case 0:
                    if (requestPermission()) {
                        JumperManager.showChoosePic(PublishActivity.this);
                    }
                    break;
                case 1:
                    showFramgent(countryFragment, emojiFragment);
                    showBottom(true);
                    break;
                case 2:
                    showFramgent(emojiFragment, countryFragment);
                    showBottom(true);
                    break;
            }
        }
    };


    private void showBottom(boolean flag) {
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) bindView.emojlayout.getLayoutParams();
        lp.height = CacheUtils.getIns().getInPutHeight();
        bindView.emojlayout.setLayoutParams(lp);
        if (flag) {
            ViewUtils.hideInput(PublishActivity.this);
            bindView.emojlayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    bindView.emojlayout.setVisibility(View.VISIBLE);
                }
            }, 60);
        } else {
            bindView.emojlayout.setVisibility(View.GONE);

        }
    }

    private void showNormalTab() {
        for (int i = 0; i < bindView.bottomCotrol.getChildCount(); i++) {
            bindView.bottomCotrol.getChildAt(i).setSelected(false);
        }
    }

    private void showFramgent(Fragment hide, Fragment show) {
        transaction = manager.beginTransaction();
        if (!show.isAdded()) {
            transaction.hide(hide).add(R.id.emojlayout, hide).show(show).commit();
        } else {
            transaction.hide(hide).show(show).commit();
        }
    }


    @Override
    protected void update(EventMessage message) {
        switch (message.getMsgId()) {
            case EventCode.BOTTOM_BLOCK_ITEM_CODE:
                block = (Block) message.getObject();
                apiBody.addBlockId(block);
                break;
            case EventCode.EXPRESSION_CODE:
                Spannable spannable = (Spannable) message.getObject();
                bindView.editText.getText().insert(bindView.editText.getSelectionStart(), spannable);
                break;
            case EventCode.EXPRESSION_DELETE_CODE:
                ViewUtils.deleteText(bindView.editText);
                break;
        }
    }

    @Override
    protected void readExternalStoreage() {
        super.readExternalStoreage();
        JumperManager.showChoosePic(PublishActivity.this);

    }
}
