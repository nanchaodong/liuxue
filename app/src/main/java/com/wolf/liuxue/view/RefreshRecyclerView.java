package com.wolf.liuxue.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.wolf.liuxue.R;
import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.bean.HeaderItem;
import com.wolf.liuxue.databinding.HeaderItemBinding;
import com.wolf.liuxue.holder.HeaderItemHolder;

/**
 * Created by nanchaodong on 2017/10/16.
 */

public class RefreshRecyclerView extends RecyclerView {
    private HeaderItemBinding itemBinding;
    private boolean isMoved = false;
    private boolean isScaled = false;
    private float dyStart = 0.0f;
    private GridLayoutManager manager;
    private Context context;
    private BaseRecyclerAdapter mAdapter;
    private HeaderItem headerItem;
    private RefreshListener listener;
    private boolean canRfresh = true;

    public void setListener(RefreshListener listener) {
        this.listener = listener;
    }

    public RefreshRecyclerView(Context context) {
        super(context);
        initRefreshHeader(context);
    }

    public RefreshRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initRefreshHeader(context);
    }

    public RefreshRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initRefreshHeader(context);
    }

    private void initRefreshHeader(final Context context) {
        this.context = context;

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (itemBinding == null) {
                    RecyclerView.ViewHolder holder = RefreshRecyclerView.this.findViewHolderForLayoutPosition(0);
                    if (holder != null) {
                        if (holder instanceof HeaderItemHolder) {
                            HeaderItemHolder headerItemHolder = (HeaderItemHolder) holder;
                            itemBinding = headerItemHolder.getBindView();
                        }
                    }
                }
                if (itemBinding != null && listener != null && canRfresh) {

                    if (mAdapter == null || headerItem == null) {
                        Adapter adapter = RefreshRecyclerView.this.getAdapter();
                        mAdapter = (BaseRecyclerAdapter) adapter;
                        headerItem = mAdapter.getHeaderBean();
                    }
                    LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) itemBinding.header.getLayoutParams();
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_UP:
                            isMoved = false;
                            if (isScaled) {
                                if (headerItem.getStatus() == HeaderItem.Anim.RELEASE.ordinal()) {
                                    headerItem.setStatus(HeaderItem.Anim.REFRESH.ordinal());
                                    if (listener != null) {
                                        listener.onRefresh();
                                    }
                                } else {
                                    replyImage();
                                }
                                isScaled = false;
                            }
                            break;
                        case MotionEvent.ACTION_MOVE:
                            if (!isMoved) {
                                dyStart = event.getY();
                                isMoved = true;
                            }
                            if (manager.findFirstCompletelyVisibleItemPosition() == 0 && headerItem.getStatus() != HeaderItem.Anim.REFRESH.ordinal()) {
                                if (event.getY() - dyStart > 0) {
                                    int distance = (int) ((event.getY() - dyStart) * 0.5); // 滚动距离乘以一个系数
                                    if ((int) (distance - context.getResources().getDimensionPixelSize(R.dimen.d100)) <= 0) {
                                        lp.setMargins(0, (int) (distance - context.getResources().getDimensionPixelSize(R.dimen.d100)), 0, 0);
                                        itemBinding.header.setLayoutParams(lp);
                                        headerItem.setStatus(HeaderItem.Anim.PULL.ordinal());
                                    } else {
                                        headerItem.setStatus(HeaderItem.Anim.RELEASE.ordinal());
                                    }
                                    isScaled = true;
                                    return true; // 返回true表示已经完成触摸事件，不再处理
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }


                    }
                }

                return false;
            }
        });
    }


    public void setManager(final GridLayoutManager manager) {
        this.manager = manager;
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return manager.getSpanCount();
                }
                return 1;
            }
        });
        this.setLayoutManager(manager);

    }

    private void replyImage() {
        if (itemBinding != null) {

            final LinearLayout.LayoutParams headerLp = (LinearLayout.LayoutParams) itemBinding.header.getLayoutParams();
            final float top = ((LinearLayout.LayoutParams) itemBinding.header.getLayoutParams()).topMargin;
            final float newTop = -context.getResources().getDimensionPixelOffset(R.dimen.d100);
            // 设置动画
            final ValueAnimator anim = ObjectAnimator.ofFloat(0.0F, 1.0F).setDuration(200);

            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float cVal = (Float) animation.getAnimatedValue();
                    headerLp.topMargin = (int) (top - (top - newTop) * cVal);
                    itemBinding.header.setLayoutParams(headerLp);
                }
            });
            anim.start();
        }

    }

    public interface RefreshListener {
        void onRefresh();
    }

    public void suc() {
        if (headerItem != null) {
            headerItem.setStatus(HeaderItem.Anim.COMPLETE.ordinal());
        }
        replyImage();
    }

    public void fail() {
        if (headerItem != null) {
            headerItem.setStatus(HeaderItem.Anim.FAIL.ordinal());
        }
        replyImage();
    }

    public void setCanRfresh(boolean canRfresh) {
        this.canRfresh = canRfresh;
    }
}
