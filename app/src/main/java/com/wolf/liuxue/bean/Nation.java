package com.wolf.liuxue.bean;

import java.io.Serializable;

/**
 * Created by nanchaodong on 2017/5/5.
 */

public class Nation implements Serializable {
    private int nationId;
    private String name;
    private String circleImageUrl;
    private String imageUrl;
    private String bgUrl;

    public Nation(int nationId, String name, String circleImageUrl, String imageUrl, String bgUrl) {
        this.nationId = nationId;
        this.name = name;
        this.circleImageUrl = circleImageUrl;
        this.imageUrl = imageUrl;
        this.bgUrl = bgUrl;
    }

    public Nation() {
    }

    public int getNationId() {
        return nationId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCircleImageUrl() {
        return circleImageUrl;
    }

    public void setCircleImageUrl(String circleImageUrl) {
        this.circleImageUrl = circleImageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBgUrl() {
        return bgUrl;
    }

    public void setBgUrl(String bgUrl) {
        this.bgUrl = bgUrl;
    }

    @Override
    public String toString() {
        return "Nation{" +
                "nationId=" + nationId +
                ", name='" + name + '\'' +
                ", circleImageUrl='" + circleImageUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", bgUrl='" + bgUrl + '\'' +
                '}';
    }
}
