package com.wolf.liuxue.holder;

import android.view.View;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BaseRecyclerHolder;
import com.wolf.liuxue.bean.Article;
import com.wolf.liuxue.databinding.TabArticleItemBinding;

/**
 * Created by nanchaodong on 2017/5/11.
 */

public class TabArticleItemHolder extends BaseRecyclerHolder<Article, TabArticleItemBinding> {
    public TabArticleItemHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void setUp(Article model, int position) {
        bindView.setArticle(model);
    }
}
