package com.wolf.liuxue.view;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.wolf.liuxue.R;
import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.bean.Block;
import com.wolf.liuxue.bean.EventMessage;
import com.wolf.liuxue.databinding.FBlockBinding;
import com.wolf.liuxue.presenter.PresenterClick;
import com.wolf.liuxue.utils.CacheUtils;
import com.wolf.liuxue.utils.EventPush;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by nanchaodong on 2017/5/10.
 */

public class BlockFragment extends DialogFragment {
    private static final String TAG = "BlockFragment";
    private FBlockBinding bindView;
    private List<Block> blocks = CacheUtils.getIns().getBlocks();
    private BaseRecyclerAdapter baseRecyclerAdapter;
    private GridLayoutManager manager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventPush.ins().register(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            dialog.getWindow().setLayout((int) (dm.widthPixels * 0.8), ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCanceledOnTouchOutside(false);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        bindView = DataBindingUtil.inflate(inflater, R.layout.f_block, null, false);
        bindView.setPresenter(click);
        return bindView.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        manager = new GridLayoutManager(getActivity(), 4);
        baseRecyclerAdapter = new BaseRecyclerAdapter(getActivity());
        bindView.recyclerView.setAdapter(baseRecyclerAdapter);
        bindView.recyclerView.setLayoutManager(manager);
        baseRecyclerAdapter.addData(blocks);
    }

    private PresenterClick click = new PresenterClick() {
        @Override
        public void click() {
            super.click();
            BlockFragment.this.dismiss();
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventPush.ins().unRegister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(EventMessage event) {
        if (event.getMsgId() == 1000) {
            this.dismiss();
            if (listener != null) {
                listener.clickBlockItem((Block) event.getObject());
            }
        }
    }

    public interface BlockItemClickListener {
        void clickBlockItem(Block block);
    }

    private BlockItemClickListener listener;

    public void setListener(BlockItemClickListener listener) {
        this.listener = listener;
    }
}
