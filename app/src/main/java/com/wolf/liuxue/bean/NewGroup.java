package com.wolf.liuxue.bean;

import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryImpl;

import java.util.List;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class NewGroup implements PresentImpl{
    private String groudId;
    private String groupName;
    private int refresh;
    private String refreshText;
    private String refreshUrl;
    private String catId;
    private List<New> records;

    public NewGroup(String groudId, String groupName, int refresh, String refreshText, String refreshUrl, List<New> records) {
        this.groudId = groudId;
        this.groupName = groupName;
        this.refresh = refresh;
        this.refreshText = refreshText;
        this.refreshUrl = refreshUrl;
        this.records = records;
    }

    public NewGroup() {
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getGroudId() {
        return groudId;
    }

    public void setGroudId(String groudId) {
        this.groudId = groudId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getRefresh() {
        return refresh;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    public String getRefreshText() {
        return refreshText;
    }

    public void setRefreshText(String refreshText) {
        this.refreshText = refreshText;
    }

    public String getRefreshUrl() {
        return refreshUrl;
    }

    public void setRefreshUrl(String refreshUrl) {
        this.refreshUrl = refreshUrl;
    }

    public List<New> getRecords() {
        return records;
    }

    public void setRecords(List<New> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "NewGroup{" +
                "groudId='" + groudId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", refresh=" + refresh +
                ", refreshText='" + refreshText + '\'' +
                ", refreshUrl='" + refreshUrl + '\'' +
                ", records=" + records +
                '}';
    }

    @Override
    public int itemType(TypeFactoryImpl typeFactory) {
        return typeFactory.type(this);
    }
}
