package com.wolf.liuxue.holder;

import android.view.View;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BaseRecyclerHolder;
import com.wolf.liuxue.bean.Image;
import com.wolf.liuxue.databinding.ImageSelectItemBinding;
import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.PresenterClick;

/**
 * Created by nanchaodong on 2017/5/17.
 */

public class ImageSelectItemHolder extends BaseRecyclerHolder<Image, ImageSelectItemBinding> {
    public ImageSelectItemHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void setUp(Image model, int position) {
        bindView.setImage(model);
        bindView.setPresenter(click);

    }

    private PresenterClick click = new PresenterClick() {
        @Override
        public void click(PresentImpl present) {
            Image image = (Image) present;
            image.setSelect(!image.isSelect());
        }


    };
}
