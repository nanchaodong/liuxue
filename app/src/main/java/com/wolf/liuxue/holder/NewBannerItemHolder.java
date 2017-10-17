package com.wolf.liuxue.holder;

import android.view.View;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BaseRecyclerHolder;
import com.wolf.liuxue.bean.TopAdv;
import com.wolf.liuxue.bean.TopAdvert;
import com.wolf.liuxue.databinding.NewBannerItemBinding;
import com.wolf.liuxue.http.PicassoImageLoader;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class NewBannerItemHolder extends BaseRecyclerHolder<TopAdvert, NewBannerItemBinding> {
    public NewBannerItemHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void setUp(TopAdvert model, int position) {
        List<TopAdv> topAdvs = model.getTopAdvs();
        List<String> list = new ArrayList<>();
        for (TopAdv topAdv : topAdvs) {
            list.add(topAdv.getImageUrl());
        }
        bindView.banner.setIndicatorGravity(BannerConfig.CENTER);
        bindView.banner.setImages(list).setImageLoader(new PicassoImageLoader()).start();
    }
}
