package com.wolf.liuxue.http;

import com.wolf.liuxue.bean.JResult;
import com.wolf.liuxue.bean.PagerList;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class RxHelper {

    public static <T> Observable.Transformer<JResult<T>, T> handleResult() {
        return new Observable.Transformer<JResult<T>, T>() {
            @Override
            public Observable<T> call(Observable<JResult<T>> jResultObservable) {
                return jResultObservable.flatMap(new Func1<JResult<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(final JResult<T> tjResult) {
                        return Observable.create(new Observable.OnSubscribe<T>() {

                            @Override
                            public void call(Subscriber<? super T> subscriber) {
                                try {
                                    if (tjResult.getErrorcode() == 0){
                                        subscriber.onCompleted();
                                        subscriber.onNext(tjResult.getData());
                                    }else {
                                        throw new ApiException(tjResult.getErrorcode());
                                    }
                                }catch (Exception e){
                                    throw new ApiException("请检查网络连接");
                                }


                            }
                        });
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
    public static <T> Observable.Transformer<JResult<PagerList<List<T>>>,List<T>> handleList(){
        return new Observable.Transformer<JResult<PagerList<List<T>>>, List<T>>() {

            @Override
            public Observable<List<T>> call(Observable<JResult<PagerList<List<T>>>> jResultObservable) {
                return jResultObservable.flatMap(new Func1<JResult<PagerList<List<T>>>, Observable<List<T>>>() {
                    @Override
                    public Observable<List<T>> call(final JResult<PagerList<List<T>>> pagerListJResult) {
                        return Observable.create(new Observable.OnSubscribe<List<T>>() {
                            @Override
                            public void call(Subscriber<? super List<T>> subscriber) {
                                try {
                                    if (pagerListJResult.getErrorcode() == 0){
                                        subscriber.onCompleted();
                                        subscriber.onNext(pagerListJResult.getData().getRecords());
                                    }else {
                                        throw new ApiException(pagerListJResult.getErrorcode());
                                    }
                                }catch (Exception e){
                                    throw new ApiException("请检查网络连接");
                                }


                            }
                        });
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
