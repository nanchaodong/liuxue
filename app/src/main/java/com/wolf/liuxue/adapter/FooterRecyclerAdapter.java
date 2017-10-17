package com.wolf.liuxue.adapter;

import android.content.Context;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.bean.Footer;
import com.wolf.liuxue.bean.HeaderItem;
import com.wolf.liuxue.presenter.PresentImpl;

import java.util.List;

/**
 * Created by nanchaodong on 2017/5/11.
 */

public class FooterRecyclerAdapter extends BaseRecyclerAdapter {
    private Footer footer;


    public FooterRecyclerAdapter(Context context) {
        super(context);
        footer = new Footer(3);
    }

    public <T extends PresentImpl> void addData(List<T> list) {
        this.datas.clear();
        this.datas.add(headerItem);
        this.datas.addAll(list);
        this.datas.add(footer);
        notifyDataSetChanged();
    }


    public <T extends PresentImpl> void addMoreData(List<T> list) {
        this.datas.remove(footer);
        int startIndex = this.datas.size();
        this.datas.addAll(list);
        this.datas.add(footer);
        notifyItemRangeChanged(startIndex, datas.size() - 1);
    }

    public void setFooter(int footId) {
        this.footer.setFootId(footId);
    }

    public int getSize() {
        this.datas.remove(footer);
        int size = this.datas.size();
        this.datas.add(footer);
        return size -1;
    }
}
