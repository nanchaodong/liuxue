package com.wolf.liuxue.utils;

import android.content.Context;
import android.view.WindowManager;

import com.wolf.liuxue.App;
import com.wolf.liuxue.R;

/**
 * Created by nanchaodong on 2017/5/17.
 */

public class ScreenUtils {
    public static int getScreenWidth() {
        WindowManager manager = (WindowManager) App.getIns().getSystemService(Context.WINDOW_SERVICE);
        return manager.getDefaultDisplay().getWidth();
    }

    public static int getScreenHeight() {
        WindowManager manager = (WindowManager) App.getIns().getSystemService(Context.WINDOW_SERVICE);
        return manager.getDefaultDisplay().getHeight();
    }

    public static int getSelectImageHeight() {
        int distance = App.getIns().getResources().getDimensionPixelOffset(R.dimen.d3) * 6;
        int width = getScreenWidth() - distance;
        return width / 3;
    }
}
