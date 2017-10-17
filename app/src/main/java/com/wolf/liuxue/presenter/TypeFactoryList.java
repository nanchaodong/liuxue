package com.wolf.liuxue.presenter;

import android.view.View;

import com.wolf.liuxue.R;
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
import com.wolf.liuxue.holder.BlockItemHolder;
import com.wolf.liuxue.holder.BottomBlockItemHolder;
import com.wolf.liuxue.holder.ExpressionItemHolder;
import com.wolf.liuxue.holder.FooterHolder;
import com.wolf.liuxue.holder.HeaderItemHolder;
import com.wolf.liuxue.holder.ImageSelectItemHolder;
import com.wolf.liuxue.holder.NewBannerItemHolder;
import com.wolf.liuxue.holder.NewGroupChildOneItemHolder;
import com.wolf.liuxue.holder.NewGroupChildTwoItemHolder;
import com.wolf.liuxue.holder.NewGroupItemHolder;
import com.wolf.liuxue.holder.NewsBtnChildItemHolder;
import com.wolf.liuxue.holder.NewsBtnItemHolder;
import com.wolf.liuxue.holder.TabArticleItemHolder;
import com.wolf.liuxue.holder.TestBeanHolder;

import java.util.Date;
import java.util.List;

/**
 * Created by nanchaodong on 2017/5/10.
 */

public class TypeFactoryList implements TypeFactoryImpl {
    private static final int BLOCK_ITEM = R.layout.block_item;
    private static final int TAB_ARTICLE_ITEM = R.layout.tab_article_item;
    private static final int FOOTER_ITEM = R.layout.footer_item;
    private static final int NEW_BANNER_ITEM = R.layout.new_banner_item;
    private static final int NEWS_BTN_ITEM = R.layout.news_btn_item;
    private static final int NEWS_BTN_CHILD_ITEM = R.layout.news_btn_child_item;
    private static final int NEW_GROUP_ITEM = R.layout.new_group_item;
    private static final int NEW_GROUP_CHILD_ONE_ITEM = R.layout.new_group_child_one_item;
    private static final int NEW_GROUP_CHILD_TWO_ITEM = R.layout.new_group_child_two_item;
    private static final int BOTTON_BLOCK_ITEM = R.layout.bottom_block_item;
    private static final int EXPRESSION_ITEM = R.layout.expresion_item;
    private static final int IMAGE_SELECT_ITEM = R.layout.image_select_item;
    private static final int TEST_BEAN_ITEM = R.layout.test_bean_item;
    private static final int HEADER_ITEM = R.layout.header_item;

    @Override
    public int type(Block block) {
        if (block.getItem() == Block.Type.BOTTOM.ordinal()) {
            return BOTTON_BLOCK_ITEM;
        }
        return BLOCK_ITEM;
    }

    @Override
    public int type(Article article) {
        return TAB_ARTICLE_ITEM;
    }

    @Override
    public int type(Footer footer) {
        return FOOTER_ITEM;
    }

    @Override
    public int type(TopAdvert topAdvert) {
        return NEW_BANNER_ITEM;
    }

    @Override
    public int type(NewsBtn newsBtn) {
        return NEWS_BTN_ITEM;
    }

    @Override
    public int type(NewBtn newBtn) {
        return NEWS_BTN_CHILD_ITEM;
    }

    @Override
    public int type(ExpressionBean bean) {
        return EXPRESSION_ITEM;
    }

    @Override
    public int type(Image image) {
        return IMAGE_SELECT_ITEM;
    }

    @Override
    public int type(AliBean aliBean) {
        return 0;
    }

    @Override
    public int type(TestBean testBean) {
        return TEST_BEAN_ITEM;
    }

    @Override
    public int type(HeaderItem headerItem) {
        return HEADER_ITEM;
    }

    @Override
    public int type(NewGroup newGroup) {
        int refresh = newGroup.getRefresh();
        if (refresh == 1) {
            List<New> records = newGroup.getRecords();
            for (New record : records) {
                record.setRow(2);
            }
        }
        return NEW_GROUP_ITEM;
    }

    @Override
    public int type(New aNew) {
        if (aNew.getRow() == 0) {
            return NEW_GROUP_CHILD_ONE_ITEM;

        } else {
            return NEW_GROUP_CHILD_TWO_ITEM;
        }
    }


    @Override
    public BaseRecyclerHolder create(int itemType, View itemView, BaseRecyclerAdapter adapter) {
        switch (itemType) {
            case BLOCK_ITEM:
                return new BlockItemHolder(itemView, adapter);
            case TAB_ARTICLE_ITEM:
                return new TabArticleItemHolder(itemView, adapter);
            case FOOTER_ITEM:
                return new FooterHolder(itemView, adapter);
            case NEW_BANNER_ITEM:
                return new NewBannerItemHolder(itemView, adapter);
            case NEWS_BTN_ITEM:
                return new NewsBtnItemHolder(itemView, adapter);
            case NEWS_BTN_CHILD_ITEM:
                return new NewsBtnChildItemHolder(itemView, adapter);
            case NEW_GROUP_ITEM:
                return new NewGroupItemHolder(itemView, adapter);
            case NEW_GROUP_CHILD_ONE_ITEM:
                return new NewGroupChildOneItemHolder(itemView, adapter);
            case NEW_GROUP_CHILD_TWO_ITEM:
                return new NewGroupChildTwoItemHolder(itemView, adapter);
            case BOTTON_BLOCK_ITEM:
                return new BottomBlockItemHolder(itemView, adapter);
            case EXPRESSION_ITEM:
                return new ExpressionItemHolder(itemView, adapter);
            case IMAGE_SELECT_ITEM:
                return new ImageSelectItemHolder(itemView,adapter);
            case TEST_BEAN_ITEM:
                return new TestBeanHolder(itemView, adapter);
            case HEADER_ITEM:
                return new HeaderItemHolder(itemView,adapter);
        }
        return null;
    }


}
