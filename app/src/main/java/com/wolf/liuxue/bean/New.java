package com.wolf.liuxue.bean;

import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryImpl;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class New implements PresentImpl {
    private String articleId;
    private String userId;
    private String title;
    private String readCount;
    private String shortContent;
    private String advertUrl;
    private String createTime;
    private String articleUrl;
    private int isActivity;
    private boolean isCollection;
    private int row;

    public New(String articleId, String userId, String title, String readCount, String shortContent, String advertUrl, String createTime, String articleUrl, int isActivity, boolean isCollection) {
        this.articleId = articleId;
        this.userId = userId;
        this.title = title;
        this.readCount = readCount;
        this.shortContent = shortContent;
        this.advertUrl = advertUrl;
        this.createTime = createTime;
        this.articleUrl = articleUrl;
        this.isActivity = isActivity;
        this.isCollection = isCollection;
    }

    public New() {
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getAdvertUrl() {
        return advertUrl;
    }

    public void setAdvertUrl(String advertUrl) {
        this.advertUrl = advertUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public int getIsActivity() {
        return isActivity;
    }

    public void setIsActivity(int isActivity) {
        this.isActivity = isActivity;
    }

    public boolean isCollection() {
        return isCollection;
    }

    public void setCollection(boolean collection) {
        isCollection = collection;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "New{" +
                "articleId='" + articleId + '\'' +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", readCount='" + readCount + '\'' +
                ", shortContent='" + shortContent + '\'' +
                ", advertUrl='" + advertUrl + '\'' +
                ", createTime='" + createTime + '\'' +
                ", articleUrl='" + articleUrl + '\'' +
                ", isActivity=" + isActivity +
                ", isCollection=" + isCollection +
                '}';
    }

    @Override
    public int itemType(TypeFactoryImpl typeFactory) {
        return typeFactory.type(this);
    }
}
