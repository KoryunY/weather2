package com.gmail.yeritsyankoryun.weather.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class WeatherInfoId implements Serializable {
    private String country;
    private String city;

    @Autowired
    public WeatherInfoId() {
    }

    @Autowired
    public WeatherInfoId(String country,String city) {
        this.country = country;
        this.city = city;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherInfoId that = (WeatherInfoId) o;
        return Objects.equals(country, that.country) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }
}
