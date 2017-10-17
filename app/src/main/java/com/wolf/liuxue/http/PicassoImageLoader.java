package com.wolf.liuxue.http;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wolf.liuxue.R;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class PicassoImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Picasso.with(context).load((String) path).placeholder(R.mipmap.ic_loading).error(R.mipmap.ic_loading).into(imageView);

    }
}
