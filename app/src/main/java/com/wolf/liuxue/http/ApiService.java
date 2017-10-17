package com.wolf.liuxue.http;

import com.wolf.liuxue.bean.Article;
import com.wolf.liuxue.bean.Config;
import com.wolf.liuxue.bean.JResult;
import com.wolf.liuxue.bean.New;
import com.wolf.liuxue.bean.NewList;
import com.wolf.liuxue.bean.PagerList;
import com.wolf.liuxue.bean.User;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import rx.Observable;

/**
 * Created by nanchaodong on 2017/5/5.
 */

public interface ApiService {

    @Multipart
    @POST("User/login")
    Observable<JResult<User>> login(@PartMap Map<String, RequestBody> map);

    @Multipart
    @POST("User/getConfig")
    Observable<JResult<List<Config>>> getConfig(@PartMap Map<String, RequestBody> map);

    @Multipart
    @POST("Forum/getAllHotArticles1")
    Observable<JResult<PagerList<List<Article>>>> getNewArticles(@PartMap Map<String, RequestBody> map);

    @Multipart
    @POST("News/getNewsHome")
    Observable<JResult<NewList>> getNewsHome(@PartMap Map<String, RequestBody> map);

    @Multipart
    @POST("News/changeStrategy")
    Observable<JResult<NewList>> getChangList(@PartMap Map<String, RequestBody> map);

    @Multipart
    @POST("News/getNewsList")
    Observable<JResult<PagerList<List<New>>>> getNewsList(@PartMap Map<String, RequestBody> map);
    @Multipart
    @POST("News/getNewsList")
    Observable<ResponseBody> getNewsLists(@PartMap Map<String, RequestBody> map);
}
