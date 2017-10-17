package com.wolf.liuxue.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.wolf.liuxue.App;
import com.wolf.liuxue.R;
import com.wolf.liuxue.base.BindFragment;
import com.wolf.liuxue.databinding.TabViewBinding;
import com.wolf.liuxue.presenter.PresenterClick;

import java.util.List;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class TabView extends LinearLayout {
    private String text;
    private Drawable image;
    private TabViewBinding bindView;
    private boolean selected;
    private int position;
    private List<BindFragment> list;
    private List<TabView> tabViews;
    private FragmentManager manager;
    private BindFragment currentFragment;

    public TabView(Context context) {
        this(context, null);
    }

    public TabView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bindView = DataBindingUtil.inflate(App.getInflater(), R.layout.tab_view, this, true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TabView);
        text = typedArray.getString(R.styleable.TabView_text);
        image = typedArray.getDrawable(R.styleable.TabView_image);
        selected = typedArray.getBoolean(R.styleable.TabView_selected, false);
        position = typedArray.getInteger(R.styleable.TabView_position, 0);
        typedArray.recycle();
        bindView.text.setText(text);
        image.setBounds(0, 0, image.getMinimumWidth(), image.getMinimumHeight());
        bindView.text.setCompoundDrawables(null, image, null, null);
        bindView.text.setSelected(selected);
        bindView.setPresenter(click);


    }

    public void setBindFragment(List<BindFragment> list) {
        this.list = list;
    }

    public void setTabViews(List<TabView> list) {
        this.tabViews = list;
    }

    public void setManager(FragmentManager manager) {
        this.manager = manager;
    }

    public void setCurrentFragment(BindFragment currentFragment) {
        this.currentFragment = currentFragment;

    }

    private PresenterClick click = new PresenterClick() {
        @Override
        public void click() {
            BindFragment fragment = list.get(position);
            if (currentFragment != fragment) {
                FragmentTransaction transaction = manager.beginTransaction();
                if (fragment.isAdded()) {
                    transaction.hide(currentFragment).show(fragment).commit();
                } else {
                    transaction.add(R.id.container, fragment).hide(currentFragment).show(fragment).commit();
                }
                resetCurrentFragment(fragment);
            }


        }
    };

    public void resetCurrentFragment(BindFragment fragment) {
        for (TabView tabView : tabViews) {
            tabView.setCurrentFragment(fragment);
            tabView.setNomalTextColor();
        }
        bindView.text.setSelected(true);
    }

    public void setNomalTextColor() {
        bindView.text.setSelected(false);
    }


}
