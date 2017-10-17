package com.wolf.liuxue.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.wolf.liuxue.activity.ImageSelectActivity;
import com.wolf.liuxue.activity.MainActivity;
import com.wolf.liuxue.activity.NewsListActivity;
import com.wolf.liuxue.activity.PublishActivity;
import com.wolf.liuxue.bean.NewGroup;
import com.wolf.liuxue.common.IntentKey;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class JumperManager {
    public static void showMain(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        ((Activity)context).finish();
    }
    public static void showNewListActivity(Context context, NewGroup newGroup){
        Intent intent = new Intent(context, NewsListActivity.class);
        intent.putExtra(IntentKey.KEY_NEWGROUP,newGroup);
        context.startActivity(intent);
    }
    public static void showPublishActivity(Context context){
        Intent intent = new Intent(context, PublishActivity.class);
        context.startActivity(intent);
    }
    public static void showChoosePic(Context context){
        Intent intent = new Intent(context, ImageSelectActivity.class);
        context.startActivity(intent);
    }
}
