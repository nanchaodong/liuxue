package com.wolf.liuxue.bean;

import java.util.List;

/**
 * Created by nanchaodong on 2017/5/12.
 */

public class NewList {
    private List<TopAdv> topAdvs;
    private List<NewBtn> nation;
    private List<NewGroup> newsGroup;
    private List<New> records;
    private String nextIndex;

    public NewList(List<TopAdv> topAdvs, List<NewBtn> nation, List<NewGroup> newsGroup) {
        this.topAdvs = topAdvs;
        this.nation = nation;
        this.newsGroup = newsGroup;
    }

    public NewList() {
    }

    public List<TopAdv> getTopAdvs() {
        return topAdvs;
    }

    public void setTopAdvs(List<TopAdv> topAdvs) {
        this.topAdvs = topAdvs;
    }

    public List<NewBtn> getNation() {
        return nation;
    }

    public void setNation(List<NewBtn> nation) {
        this.nation = nation;
    }

    public List<NewGroup> getNewsGroup() {
        return newsGroup;
    }


    public void setNewsGroup(List<NewGroup> newsGroup) {
        this.newsGroup = newsGroup;
    }

    public List<New> getRecords() {
        return records;
    }

    public void setRecords(List<New> records) {
        this.records = records;
    }

    public String getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(String nextIndex) {
        this.nextIndex = nextIndex;
    }

    @Override
    public String toString() {
        return "NewList{" +
                "topAdvs=" + topAdvs +
                ", nation=" + nation +
                ", newsGroup=" + newsGroup +
                '}';
    }
}
