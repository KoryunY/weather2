package com.gmail.yeritsyankoryun.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherInfoDto {
    @JsonProperty(value = "country")
    private String country;
    @JsonProperty(value = "city")
    private String city;
    @JsonProperty(value = "temperature")
    private double temperature;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
