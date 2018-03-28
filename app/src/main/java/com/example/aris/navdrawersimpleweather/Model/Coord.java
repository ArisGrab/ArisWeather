package com.example.aris.navdrawersimpleweather.Model;

/**
 * Created by al-kahyatamar on 24.03.18.
 */

public class Coord {
    private double lat;
    private double lon;

    public  Coord(double lat, double lan){
        this.lat=lat;
        this.lon=lon;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {

        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
