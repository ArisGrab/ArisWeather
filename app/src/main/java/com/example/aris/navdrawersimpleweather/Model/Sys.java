package com.example.aris.navdrawersimpleweather.Model;

/**
 * Created by al-kahyatamar on 25.03.18.
 */

public class Sys {
    private int type;
    private int id;
    private double massage;
    private String country;
    private double sunrise;
    private double sunset;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMassage() {
        return massage;
    }

    public void setMassage(double massage) {
        this.massage = massage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSunrise() {
        return sunrise;
    }

    public void setSunrise(double sunrise) {
        this.sunrise = sunrise;
    }

    public double getSunset() {
        return sunset;
    }

    public void setSunset(double sunset) {
        this.sunset = sunset;
    }

    public Sys(int type, int id, double massage, String country, double sunrise, double sunset) {

        this.type = type;
        this.id = id;
        this.massage = massage;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }
}
