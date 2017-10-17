package com.wolf.liuxue.http;

/**
 * Created by nanchaodong on 2017/5/5.
 */

public class GParam {
    private int at = 0;
    private int av = 4200;
    private String deviceId = "3577698847";
    private int dt = 1;
    private int sv = 200;

    private GParam() {

    }

    private static GParam ins;

    public static GParam getIns() {
        if (ins == null) {
            ins = new GParam();
        }
        return ins;
    }

    public int getAt() {
        return at;
    }

    public void setAt(int at) {
        this.at = at;
    }

    public int getAv() {
        return av;
    }

    public void setAv(int av) {
        this.av = av;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getSv() {
        return sv;
    }

    public void setSv(int sv) {
        this.sv = sv;
    }

    public static void setIns(GParam ins) {
        GParam.ins = ins;
    }
}
