package com.gmail.yeritsyankoryun.weather.dto;


import com.gmail.yeritsyankoryun.weather.model.WeatherInfoId;
import com.gmail.yeritsyankoryun.weather.model.WeatherType;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.*;

@IdClass(WeatherInfoId.class)
public class WeatherInfoDto {

    @Size(min = 2, max = 3)
    private String country;
    @Size(min = 2)
    private String city;
    @Min(-90)
    @Max(60)
    private Double temperature; // in// Celsius
    @Enumerated(EnumType.ORDINAL)
    private WeatherType type;
    @Min(0)
    @Max(372)
    private Integer windSpeed; // in km/h

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Double getTemperature() {
        return temperature;
    }

    public WeatherType getType() {
        return type;
    }

    public void setType(WeatherType type) {
        this.type = type;
    }

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
