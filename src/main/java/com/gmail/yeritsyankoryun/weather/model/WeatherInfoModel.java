package com.gmail.yeritsyankoryun.weather.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@IdClass(WeatherInfoId.class)
public class WeatherInfoModel {
    @Id
    @NotBlank
    @Size(min = 2, max = 3)
    private String country;
    @Id
    @NotBlank
    @Size(min = 2)
    private String city;
    @Min(-90)
    @Max(60)
    private double temperature; // in Celsius
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private WeatherType type;
    @Min(0)
    @Max(372)
    private int windSpeed; // in km/h

    @Autowired
    public WeatherInfoModel() {
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

    public WeatherType getType() {
        return type;
    }

    public void setType(WeatherType type) {
        this.type = type;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
