package com.wolf.liuxue.bean;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class TopAdv {
    private String advertId;
    private String articleId;
    private String articleTitle;
    private boolean isCollection;
    private String imageurl;
    private String linkurl;
    private int type;

    public TopAdv(String advertId, String articleId, String articleTitle, boolean isCollection, String imageUrl, String linkUrl, int type) {
        this.advertId = advertId;
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.isCollection = isCollection;
        this.imageurl = imageUrl;
        this.linkurl = linkUrl;
        this.type = type;
    }

    public TopAdv() {
    }

    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public boolean isCollection() {
        return isCollection;
    }

    public void setCollection(boolean collection) {
        isCollection = collection;
    }

    public String getImageUrl() {
        return imageurl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageurl = imageUrl;
    }

    public String getLinkUrl() {
        return linkurl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkurl = linkUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TopAdv{" +
                "advertId='" + advertId + '\'' +
                ", articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", isCollection=" + isCollection +
                ", imageUrl='" + imageurl + '\'' +
                ", linkUrl='" + linkurl + '\'' +
                ", type=" + type +
                '}';
    }
}
