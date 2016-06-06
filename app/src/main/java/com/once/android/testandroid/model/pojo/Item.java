package com.once.android.testandroid.model.pojo;

/**
 * POJO with people data
 */
public class Item{

    private String device_name;
    private String brand;
    private int awesomeness;
    private String name;
    private String picture_url;
    private int age;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Item{" +
                "device_name='" + device_name + '\'' +
                ", brand='" + brand + '\'' +
                ", awesomeness=" + awesomeness +
                ", name='" + name + '\'' +
                ", picture_url='" + picture_url + '\'' +
                ", age=" + age +
                '}';
    }

}
