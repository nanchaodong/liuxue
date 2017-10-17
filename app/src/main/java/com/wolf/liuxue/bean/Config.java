package com.wolf.liuxue.bean;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class Config {
    private String configName;
    private String configValue;

    public Config(String configName, String configValue) {
        this.configName = configName;
        this.configValue = configValue;
    }

    public Config() {
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    @Override
    public String toString() {
        return "Config{" +
                "configName='" + configName + '\'' +
                ", configValue='" + configValue + '\'' +
                '}';
    }
}
