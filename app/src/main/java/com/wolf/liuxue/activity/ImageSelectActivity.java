package com.wolf.liuxue.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wolf.liuxue.R;
import com.wolf.liuxue.base.BindActivity;
import com.wolf.liuxue.fragment.ImageSelectFragment;

/**
 * Created by nanchaodong on 2017/5/17.
 */

public class ImageSelectActivity extends BindActivity {
    private ImageSelectFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_image_select);
        showTitle(R.string.text_picture)
                .showBackImage()
                .showRightText(R.string.text_complete);
        fragment = ImageSelectFragment.getIns();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentcontainer, fragment)
                .show(fragment)
                .commit();
    }
}
