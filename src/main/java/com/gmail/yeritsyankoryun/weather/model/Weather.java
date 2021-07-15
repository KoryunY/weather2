package com.gmail.yeritsyankoryun.weather.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.UUID;

public class Weather
{
    private String country;
    private String city;
    private int temperature;

    public Weather(String country, String city, int temperature) {
        this.country = country;
        this.city = city;
        this.temperature = temperature;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
