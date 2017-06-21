package com.example.administrator.dc;



public class SightInfo {
    private String sight_name;
    private double lon;
    private double lat;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getSight_name() {
        return sight_name;
    }

    public void setSight_name(String sight_name) {
        this.sight_name = sight_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;
}
