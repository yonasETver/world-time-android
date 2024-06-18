package com.yonastedela63.worldtime.pages;

public class CountryList {
    private String location;
    private String flag;
    private String url;

    public CountryList(String location, String flag, String url) {
        this.location = location;
        this.flag = flag;
        this.url = url;
    }

    //setter method
    public void setLocation(String location) {
        this.location = location;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //getter method

    public String getLocation() {
        return location;
    }

    public String getFlag() {
        return flag;
    }

    public String getUrl() {
        return url;
    }
}
