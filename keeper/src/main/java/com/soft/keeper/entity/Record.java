package com.soft.keeper.entity;

public class Record {

    private int id;
    private int device_id;
    private int fan_state;
    private int purify_state;
    private int sensor_state;
    private double vocs;//油烟浓度
    private String create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDevice_id() {
        return device_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
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

    public double getVocs() {
        return vocs;
    }

    public void setVocs(double vocs) {
        this.vocs = vocs;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
