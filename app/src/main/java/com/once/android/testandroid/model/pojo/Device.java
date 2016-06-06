package com.once.android.testandroid.model.pojo;

/**
 * POJO with people data
 */
public class Device {

    private String device_name;
    private String brand;
    private int awesomeness;

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAwesomeness() {
        return awesomeness;
    }

    public void setAwesomeness(int awesomeness) {
        this.awesomeness = awesomeness;
    }

    @Override
    public String toString() {
        return "Device{" +
                "device_name='" + device_name + '\'' +
                ", brand='" + brand + '\'' +
                ", awesomeness=" + awesomeness +
                '}';
    }

}
