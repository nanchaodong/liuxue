package com.wolf.liuxue.bean;

import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryImpl;

import java.util.IdentityHashMap;
import java.util.regex.Pattern;

/**
 * Created by nanchaodong on 2017/5/16.
 */

public class ExpressionBean implements PresentImpl {
    private String expressText;
    private String mipmap;
    private Pattern pattern;
    private String fileName;


    public String getMipmap() {
        return mipmap;
    }

    public void setMipmap(String mipmap) {
        this.mipmap = mipmap;
    }


    public ExpressionBean(String mipmap, String expressText) {
        this.expressText = expressText;
        this.mipmap = mipmap;
        fileName = mipmap.replace("android.resource://com.wolf.liuxue/mipmap/","");
        try {
            this.pattern = Pattern.compile(Pattern.quote(expressText));

        }catch (Exception e){

        }
    }

    public ExpressionBean(String mipmap) {
        this.mipmap = mipmap;
    }

    public ExpressionBean() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExpressText() {
        return expressText;
    }

    public void setExpressText(String expressText) {
        this.expressText = expressText;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public int itemType(TypeFactoryImpl typeFactory) {
        return typeFactory.type(this);
    }
}
