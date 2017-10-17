package com.wolf.liuxue.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.service.voice.VoiceInteractionService;
import android.text.TextUtils;

import com.google.gson.reflect.TypeToken;
import com.wolf.liuxue.App;
import com.wolf.liuxue.bean.Block;
import com.wolf.liuxue.bean.Config;
import com.wolf.liuxue.bean.JResult;
import com.wolf.liuxue.bean.Nation;
import com.wolf.liuxue.bean.User;

import org.w3c.dom.Text;

import java.util.List;

import okhttp3.RequestBody;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class CacheUtils {
    private static CacheUtils ins;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private CacheUtils() {
        preferences = App.getIns().getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public static CacheUtils getIns() {
        if (ins == null) {
            synchronized (CacheUtils.class) {
                if (ins == null) {
                    ins = new CacheUtils();
                }
            }
        }
        return ins;
    }

    private static final String USER_INFO = "user_info";

    public void setUser(User user) {
        String userInfo = App.getGson().toJson(user);
        editor.putString(USER_INFO, userInfo).apply();
    }

    public User getUser() {
        String userInf = preferences.getString(USER_INFO, null);
        if (TextUtils.isEmpty(userInf)) {
            return null;
        }
        User user = App.getGson().fromJson(userInf, User.class);
        return user;
    }

    public boolean isLogin() {
        User user = getUser();
        if (user != null) {
            return true;
        }
        return false;
    }

    public void setConfig(Config config) {
        editor.putString(config.getConfigName(), config.getConfigValue()).apply();
    }

    public List<Nation> getInfoNationGroup() {
        String info = preferences.getString("infoNationGroup", null);
        if (TextUtils.isEmpty(info)) {
            return null;
        } else {
            List<Nation> list = App.getGson().fromJson(info, new TypeToken<List<Nation>>() {
            }.getType());
            return list;
        }
    }

    public List<Block> getBlocks() {
        String info = preferences.getString("publicArticleGroup", null);
        if (TextUtils.isEmpty(info)) {
            return null;
        } else {
            List<Block> list = App.getGson().fromJson(info, new TypeToken<List<Block>>() {
            }.getType());
            return list;
        }
    }

    private static final String INPUT_HEIGHT = "input_height";

    public void setInPutHeight(int height) {
        editor.putInt(INPUT_HEIGHT, height).apply();
    }
    public int getInPutHeight(){
        return preferences.getInt(INPUT_HEIGHT,0);
    }
}
