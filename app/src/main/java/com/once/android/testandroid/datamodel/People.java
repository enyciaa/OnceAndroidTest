package com.once.android.testandroid.datamodel;

/**
 * POJO with people data
 */
public class People {

    private String names;
    private String picture_url;
    private int age;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
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
