package com.gmail.yeritsyankoryun.weather.model;


public class WeatherInfoModel
{
    private String country;
    private String city;
    private double temperature;

    public WeatherInfoModel() {
    }

    public WeatherInfoModel(String country, String city, double temperature) {
        this.country = country;
        this.city = city;
        this.temperature = temperature;
    }

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
