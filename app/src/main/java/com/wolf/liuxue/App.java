package com.wolf.liuxue;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;

import com.google.gson.Gson;
import com.wolf.liuxue.common.Emoji;
import com.wolf.liuxue.utils.CacheUtils;

/**
 * Created by nanchaodong on 2017/5/5.
 */

public class App extends Application {
    private static App ins;
    private static LayoutInflater inflater;
    private static Gson gson;

    @Override
    public void onCreate() {
        super.onCreate();
        ins = (App) getApplicationContext();
        CacheUtils.getIns();
        Emoji.init();

    }

    public static App getIns() {
        return ins;
    }

    public static LayoutInflater getInflater() {
        if (inflater == null)
            inflater = (LayoutInflater) ins.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater;
    }

    public static Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

}
