package com.example.aris.navdrawersimpleweather.Model;

import java.util.List;

/**
 * Created by al-kahyatamar on 25.03.18.
 * get json from http://jsoneditoronline.org
 */

public class OpenWeatherMap {
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private Wind wind;
    private Rain rain;
    private Sys sys;
    private Clouds clouds;
    private int id;
    private int dt;
    private String name ;
    private int cod;


    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

   // public void setWeatherlist(List<Weather> weatherlist) {
   //     this.weatherlist = weatherlist;
   // }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public OpenWeatherMap(){

    }
    public OpenWeatherMap(Coord coord, List<Weather> weatherlist, String base, Main main, Wind wind, Sys sys, Clouds clouds, int id, String name,
                          int cod, int dt,Rain rain) {

        this.coord = coord;
        this.weather = weatherlist;
        this.base = base;
        this.main = main;
        this.wind = wind;
        this.sys = sys;
        this.clouds = clouds;
        this.id = id;
        this.dt=dt;
        this.name = name;
        this.cod = cod;
        this.rain = rain;
    }
}
