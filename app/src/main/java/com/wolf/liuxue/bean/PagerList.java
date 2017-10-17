package com.wolf.liuxue.bean;

import java.util.List;

/**
 * Created by nanchaodong on 2017/5/11.
 */

public class PagerList<T> {
    private int total;
    private T records;

    public PagerList(int total, T records) {
        this.total = total;
        this.records = records;
    }

    public PagerList() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getRecords() {
        return records;
    }

    public void setRecords(T records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "PagerList{" +
                "total=" + total +
                ", records=" + records +
                '}';
    }
}
