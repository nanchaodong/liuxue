package com.wolf.liuxue.holder;

import android.print.PageRange;
import android.view.View;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BaseRecyclerHolder;
import com.wolf.liuxue.bean.Block;
import com.wolf.liuxue.common.EventCode;
import com.wolf.liuxue.databinding.BlockItemBinding;
import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.PresenterClick;
import com.wolf.liuxue.utils.EventPush;

/**
 * Created by nanchaodong on 2017/5/10.
 */

public class BlockItemHolder extends BaseRecyclerHolder<Block, BlockItemBinding> {


    public BlockItemHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void setUp(Block model, int position) {
        bindView.setBlock(model);
        bindView.setPresenter(click);
    }

    private PresenterClick click = new PresenterClick() {
        @Override
        public void click(PresentImpl present) {
            super.click(present);
            Block block = (Block) present;
            EventPush.ins().send(EventCode.BLOCK_ITEM_CODE, block);

        }
    };
}
