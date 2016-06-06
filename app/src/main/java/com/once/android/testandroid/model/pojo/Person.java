package com.once.android.testandroid.model.pojo;

/**
 * POJO with people data
 */
public class Person extends Item {

    private String names;
    private String picture_url;
    private int age;

    public String getName() {
        return names;
    }

    public void setName(String names) {
        this.names = names;
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
        return "People{" +
                "names='" + names + '\'' +
                ", picture_url='" + picture_url + '\'' +
                ", age=" + age +
                '}';
    }

}
