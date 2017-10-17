package com.wolf.liuxue.holder;

import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BaseRecyclerHolder;
import com.wolf.liuxue.bean.ExpressionBean;
import com.wolf.liuxue.common.Emoji;
import com.wolf.liuxue.common.EventCode;
import com.wolf.liuxue.databinding.ExpresionItemBinding;
import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.PresenterClick;
import com.wolf.liuxue.utils.EventPush;

/**
 * Created by nanchaodong on 2017/5/16.
 */

public class ExpressionItemHolder extends BaseRecyclerHolder<ExpressionBean, ExpresionItemBinding> {

    public ExpressionItemHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void setUp(ExpressionBean model, int position) {
        bindView.setExpression(model);
        bindView.setPresenter(click);
    }
    private  PresenterClick click = new PresenterClick(){
        @Override
        public void click(PresentImpl present) {
            super.click(present);
            ExpressionBean bean = (ExpressionBean) present;
            if (!TextUtils.isEmpty(bean.getExpressText())){
                Spannable span =  Emoji.getSimledText(mCtx,bean.getExpressText());
                EventPush.ins().send(EventCode.EXPRESSION_CODE,span);
            }else {
                EventPush.ins().send(EventCode.EXPRESSION_DELETE_CODE,null);
            }

        }
    };
}
