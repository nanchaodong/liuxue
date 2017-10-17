package com.wolf.liuxue.bean;

/**
 * Created by nanchaodong on 2017/5/5.
 */

public class JResult<T> {
    private int result;
    private int errorcode;
    private T data;
    private String timestamp;

    public JResult(int result, int errorcode, T data, String timestamp) {
        this.result = result;
        this.errorcode = errorcode;
        this.data = data;
        this.timestamp = timestamp;
    }

    public JResult() {
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "JResult{" +
                "result=" + result +
                ", errorcode=" + errorcode +
                ", data=" + data +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
