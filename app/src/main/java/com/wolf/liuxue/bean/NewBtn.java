package com.wolf.liuxue.bean;

import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryImpl;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class NewBtn implements PresentImpl{
    private String name;
    private String nationName;
    private String nationUrl;
    private String circleImageUrl;

    public NewBtn(String name, String nationName, String nationUrl, String circleImageUrl) {
        this.name = name;
        this.nationName = nationName;
        this.nationUrl = nationUrl;
        this.circleImageUrl = circleImageUrl;
    }

    public NewBtn() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getNationUrl() {
        return nationUrl;
    }

    public void setNationUrl(String nationUrl) {
        this.nationUrl = nationUrl;
    }

    public String getCircleImageUrl() {
        return circleImageUrl;
    }

    public void setCircleImageUrl(String circleImageUrl) {
        this.circleImageUrl = circleImageUrl;
    }

    @Override
    public String toString() {
        return "NewBtn{" +
                "name='" + name + '\'' +
                ", nationName='" + nationName + '\'' +
                ", nationUrl='" + nationUrl + '\'' +
                ", circleImageUrl='" + circleImageUrl + '\'' +
                '}';
    }

    @Override
    public int itemType(TypeFactoryImpl typeFactory) {
        return typeFactory.type(this);
    }
}
