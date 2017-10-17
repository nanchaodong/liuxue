package com.wolf.liuxue.presenter;

import android.view.View;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BaseRecyclerHolder;
import com.wolf.liuxue.bean.AliBean;
import com.wolf.liuxue.bean.Article;
import com.wolf.liuxue.bean.Block;
import com.wolf.liuxue.bean.ExpressionBean;
import com.wolf.liuxue.bean.Footer;
import com.wolf.liuxue.bean.HeaderItem;
import com.wolf.liuxue.bean.Image;
import com.wolf.liuxue.bean.New;
import com.wolf.liuxue.bean.NewBtn;
import com.wolf.liuxue.bean.NewGroup;
import com.wolf.liuxue.bean.NewsBtn;
import com.wolf.liuxue.bean.TestBean;
import com.wolf.liuxue.bean.TopAdvert;

/**
 * Created by nanchaodong on 2017/5/10.
 */

public interface TypeFactoryImpl {

    int type(Block block);

    int type(Article article);

    int type(Footer footer);

    int type(TopAdvert topAdvert);

    int type(NewsBtn newsBtn);

    int type(NewGroup newGroup);

    int type(New aNew);

    int type(NewBtn newBtn);

    int type(ExpressionBean bean);

    int type(Image image);

    int type(AliBean aliBean);

    int type(TestBean testBean);

    int type(HeaderItem headerItem);

    BaseRecyclerHolder create(int itemType, View itemView, BaseRecyclerAdapter adapter);
}
