package com.wolf.liuxue.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wolf.liuxue.App;
import com.wolf.liuxue.R;
import com.wolf.liuxue.databinding.TopViewLayoutBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/5/5.
 */

public class TopView extends RelativeLayout {
    private TopViewLayoutBinding bindView;
    private List<TextView> tabs;

    public TopView(Context context) {
        this(context, null);
    }

    public TopView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        bindView = DataBindingUtil.inflate(App.getInflater(), R.layout.top_view_layout, this, true);
    }

    public void setTitle(String title) {
        bindView.title.setText(title);
    }

    public void showTabs() {
        bindView.tablayout.setVisibility(VISIBLE);
        bindView.tab0.setSelected(true);
    }

    public List<TextView> getTabs() {
        if (tabs == null) {
            tabs = new ArrayList<>();
            tabs.add(bindView.tab0);
            tabs.add(bindView.tab1);
        }
        return tabs;
    }

    public ImageView leftImage() {
        bindView.leftIcon.setVisibility(VISIBLE);
        return bindView.leftIcon;
    }

    public ImageView showBackImage() {
        bindView.leftIcon.setVisibility(VISIBLE);
        bindView.leftIcon.setImageResource(R.mipmap.btn_top_back);
        return bindView.leftIcon;
    }

    public ImageView rightImage() {
        bindView.rightIcon.setVisibility(VISIBLE);
        return bindView.rightIcon;
    }
    public TextView rightText(){
        bindView.rightTitle.setVisibility(VISIBLE);
        return bindView.rightTitle;
    }

}
