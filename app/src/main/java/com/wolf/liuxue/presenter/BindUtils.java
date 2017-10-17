package com.wolf.liuxue.presenter;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wolf.liuxue.R;
import com.wolf.liuxue.bean.Image;
import com.wolf.liuxue.common.Emoji;
import com.wolf.liuxue.utils.ScreenUtils;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class BindUtils {
    private static final String TAG = "BindUtils";

    @BindingAdapter("headUrl")
    public static void showheader(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.with(imageView.getContext()).load(url).into(imageView);
        }
    }

    @BindingAdapter("imageId")
    public static void showImageId(ImageView imageView, int imageId) {
        if (imageId != 0) {
            Picasso.with(imageView.getContext())
                    .load(imageId)
                    .placeholder(R.mipmap.ic_loading)
                    .error(R.mipmap.ic_loading)
                    .into(imageView);
        }
    }

    @BindingAdapter("imageUrl")
    public static void showImageUrl(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.with(imageView.getContext())
                    .load(url)
                    .placeholder(R.mipmap.ic_loading)
                    .error(R.mipmap.ic_loading)
                    .into(imageView);

        }
    }

    @BindingAdapter("localPath")
    public static void showLocalPath(ImageView imageView, String localPath) {
        if (!TextUtils.isEmpty(localPath)) {
            Picasso.with(imageView.getContext())
                    .load("file://" + localPath)
                    .placeholder(R.mipmap.ic_loading)
                    .error(R.mipmap.ic_loading)
                    .resize(ScreenUtils.getSelectImageHeight(), ScreenUtils.getSelectImageHeight())
                    .into(imageView);


        }
    }

    @BindingAdapter("isPraise")
    public static void showPraisePic(TextView textView, int a) {
        Drawable drawable = a == 1 ? textView.getContext().getResources().getDrawable(R.mipmap.btn_web_parise_press) :
                textView.getContext().getResources().getDrawable(R.mipmap.btn_web_parise);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(drawable, null, null, null);
    }

    @BindingAdapter("comment")
    public static void comment(TextView textView, String a) {
        Drawable drawable =
                textView.getContext().getResources().getDrawable(R.mipmap.ic_comment);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(drawable, null, null, null);
        textView.setText(a);
    }

    @BindingAdapter("select")
    public static void showSelected(TextView textView, boolean flag) {
        textView.setSelected(flag);
    }

    @BindingAdapter("imageSelect")
    public static void showSelected(ImageView imageView, boolean flag) {
        imageView.setSelected(flag);
    }

    @BindingAdapter("shortContent")
    public static void showShortContent(TextView textView, String shortContent) {
        if (!TextUtils.isEmpty(shortContent)) {
            textView.setText(Emoji.getSimledText(textView.getContext(), shortContent), TextView.BufferType.SPANNABLE);

        }

    }
}
