package com.gmail.yeritsyankoryun.weather.dto;


import com.gmail.yeritsyankoryun.weather.model.WeatherInfoId;
import com.gmail.yeritsyankoryun.weather.model.WeatherType;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.*;

@IdClass(WeatherInfoId.class)
public class WeatherInfoDto {
    @Id
    @Size(min = 2, max = 3)
    private String country;
    @Size(min = 2)
    @Id
    private String city;
    @Min(-90)
    @Max(60)
    private Double temperature; // in// Celsius
    @Enumerated(EnumType.ORDINAL)
    private WeatherType type;
    @Min(0)
    @Max(372)
    private Integer windSpeed; // in km/h

    public WeatherInfoId getWeatherInfoId() {
        return new WeatherInfoId(this.country, this.city);
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Column(name = "temperature", nullable = false)
    public Double getTemperature() {
        return temperature;
    }

    @Column(name = "type", nullable = false)
    public WeatherType getType() {
        return type;
    }

    public void setType(WeatherType type) {
        this.type = type;
    }

    @Column(name = "windSpeed", nullable = false)
    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
            this.windSpeed = windSpeed;
    }

    public void setTemperature(double temperature) {
            this.temperature = temperature;
    }

}
