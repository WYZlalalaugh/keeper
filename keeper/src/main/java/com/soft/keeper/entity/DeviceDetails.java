package com.soft.keeper.entity;

public class DeviceDetails {
    private long id; // id
    private int fan_state;// 风机状态
    private int purify_state;// 净化器状态
    private int sensor_state;// 传感器状态
    private int alarm_state;//告警状态
    private int network_type;//网络类型
    private String province;//省份
    private double longitude;//经度
    private double latitude;//维度
    private String error_log;//错误日志
    private String create_time;//创建时间
    private String update_time;//更新时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFan_state() {
        return fan_state;
    }

    public void setFan_state(int fan_state) {
        this.fan_state = fan_state;
    }

    public int getPurify_state() {
        return purify_state;
    }

    public void setPurify_state(int purify_state) {
        this.purify_state = purify_state;
    }

    public int getSensor_state() {
        return sensor_state;
    }

    public void setSensor_state(int sensor_state) {
        this.sensor_state = sensor_state;
    }

    public int getAlarm_state() {
        return alarm_state;
    }

    public void setAlarm_state(int alarm_state) {
        this.alarm_state = alarm_state;
    }

    public int getNetwork_type() {
        return network_type;
    }

    public void setNetwork_type(int network_type) {
        this.network_type = network_type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getError_log() {
        return error_log;
    }

    public void setError_log(String error_log) {
        this.error_log = error_log;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
