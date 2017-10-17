package com.wolf.liuxue.http;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.wolf.liuxue.App;
import com.wolf.liuxue.bean.Block;
import com.wolf.liuxue.bean.User;
import com.wolf.liuxue.utils.CacheUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by nanchaodong on 2017/5/5.
 */

public class ApiBody {
    private static final MediaType text_type = MediaType.parse("text/plain");
    private static final MediaType image_type = MediaType.parse("multipart/form-data");
    private Map<String, RequestBody> bodyMap;
    private Map<String, Object> jsonParamsMap;

    public ApiBody() {
        bodyMap = new HashMap<String, RequestBody>();
        jsonParamsMap = new HashMap<>();
        addG();
        addDeviceId();
        addVersionCode();
        addUserId();
    }

    public RequestBody convertToRequestBody(Object o) {
        return RequestBody.create(text_type, String.valueOf(o));
    }

    public Map<String, RequestBody> getBodyMap() {
        bodyMap.put("jsonParams", convertToRequestBody(App.getGson().toJson(jsonParamsMap)));
        return bodyMap;
    }


    public void addNationId(Object nationId) {
        jsonParamsMap.put("nationId", nationId);
    }


    public void addUserName(Object userName) {
        jsonParamsMap.put("username", userName);
    }

    private void addDeviceId() {
        jsonParamsMap.put("deviceId", GParam.getIns().getDeviceId());
    }

    public void addPassWord(Object passWord) {
        jsonParamsMap.put("password", passWord);
    }

    public void addCatId(Object catId) {
        jsonParamsMap.put("catId", catId);
    }

    public void addQsid(Object qSid) {
        jsonParamsMap.put("qsid", qSid);
    }

    public void addStartIndex(Object startIndex) {
        jsonParamsMap.put("startIndex", startIndex);
    }

    public void addPageSize(Object pageSize) {
        jsonParamsMap.put("pageSize", pageSize);
    }

    public void addTimeOrder() {
        jsonParamsMap.put("timeOrder", 1);
    }

    public void addSearchType(Object searchType) {
        jsonParamsMap.put("searchType", searchType);
    }

    public void addBlockId(Object blockId){
        jsonParamsMap.put("blockId", blockId);
    }
    private void addG() {
        jsonParamsMap.put("G", GParam.getIns());
    }

    private void addVersionCode() {
        jsonParamsMap.put("versionCode", getAppVersionName());
    }

    private void addUserId() {
        User user = CacheUtils.getIns().getUser();
        if (user != null) {
            jsonParamsMap.put("userId", user.getUserId());
        }
    }

    private String getAppVersionName() {
        String versionName = "";
        PackageManager pm = App.getIns().getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo(App.getIns().getPackageName(), 0);
            versionName = pi.versionName;
            return versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }


}
