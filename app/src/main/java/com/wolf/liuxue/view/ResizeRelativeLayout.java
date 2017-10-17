package com.wolf.liuxue.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

import com.wolf.liuxue.utils.CacheUtils;

/**
 * Created by nanchaodong on 2017/5/16.
 */

public class ResizeRelativeLayout extends RelativeLayout {
    private static final String TAG = "ResizeRelativeLayout";

    public ResizeRelativeLayout(Context context) {
        super(context);
    }

    public ResizeRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ResizeRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.i(TAG, "onSizeChanged: " + "1");
        if (oldh != 0) {
            int height = Math.abs(oldh - h);
            if (CacheUtils.getIns().getInPutHeight() == 0) {
                CacheUtils.getIns().setInPutHeight(height);
            }
        }

    }
}
