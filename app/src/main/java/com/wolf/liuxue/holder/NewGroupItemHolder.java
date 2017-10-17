package com.wolf.liuxue.holder;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.wolf.liuxue.base.BaseRecyclerAdapter;
import com.wolf.liuxue.base.BaseRecyclerHolder;
import com.wolf.liuxue.base.BindActivity;
import com.wolf.liuxue.bean.New;
import com.wolf.liuxue.bean.NewGroup;
import com.wolf.liuxue.bean.NewList;
import com.wolf.liuxue.databinding.NewGroupItemBinding;
import com.wolf.liuxue.http.Api;
import com.wolf.liuxue.http.ApiBody;
import com.wolf.liuxue.http.RxHelper;
import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.PresenterClick;
import com.wolf.liuxue.presenter.RecyclerManager;
import com.wolf.liuxue.utils.JumperManager;

import rx.Subscriber;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class NewGroupItemHolder extends BaseRecyclerHolder<NewGroup, NewGroupItemBinding> {
    private GridLayoutManager manager;
    private RecyclerManager recyclerManager;
    private ApiBody apiBody;

    public NewGroupItemHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView, adapter);
        apiBody = new ApiBody();
        apiBody.addStartIndex(4);
        apiBody.addPageSize(4);
    }

    @Override
    public void setUp(NewGroup model, int position) {
        bindView.setNewGroup(model);
        bindView.setPresenter(click);
        int refresh = model.getRefresh();
        switch (refresh) {
            case 0:
                manager = new GridLayoutManager(mCtx, 1) {
                    @Override
                    public boolean canScrollHorizontally() {
                        return false;
                    }
                };
                break;
            case 1:
                manager = new GridLayoutManager(mCtx, 2) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                break;
        }
        recyclerManager = new RecyclerManager(mCtx, bindView.recyclerView, manager);
        recyclerManager.LoadData(model.getRecords());


    }

    private PresenterClick click = new PresenterClick() {
        @Override
        public void click(PresentImpl present) {
            NewGroup newGroup = (NewGroup) present;
            int refresh = newGroup.getRefresh();
            switch (refresh) {
                case 0://更多
                    JumperManager.showNewListActivity(mCtx,newGroup);
                    break;
                case 1://换一批
                    ((BindActivity)mCtx).showProgress();
                    Api.getDefault().getChangList(apiBody.getBodyMap())
                            .compose(RxHelper.<NewList>handleResult())
                            .subscribe(new Subscriber<NewList>() {
                                @Override
                                public void onCompleted() {
                                    ((BindActivity)mCtx).dismissProgress();
                                }

                                @Override
                                public void onError(Throwable e) {
                                    ((BindActivity)mCtx).dismissProgress();
                                }

                                @Override
                                public void onNext(NewList newList) {
                                    apiBody.addStartIndex(newList.getNextIndex());
                                    if (newList.getRecords() != null && newList.getRecords().size() > 0){
                                        for (New aNew : newList.getRecords()) {
                                            aNew.setRow(2);
                                        }
                                        recyclerManager.LoadData(newList.getRecords());

                                    }
                                }
                            });

                    break;
            }
        }
    };


}
