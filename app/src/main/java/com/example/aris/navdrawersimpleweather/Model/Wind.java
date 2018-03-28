package com.example.aris.navdrawersimpleweather.Model;

/**
 * Created by al-kahyatamar on 25.03.18.
 */

public class Wind {
    private double speed;
    private double deg;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    public Wind(double speed, double deg) {

        this.speed = speed;
        this.deg = deg;
    }
}
