package com.gmail.yeritsyankoryun.weather.dto;

import com.gmail.yeritsyankoryun.weather.dto.WeatherInfoDto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WeatherInfoDtoId implements Serializable {
    @NotBlank
    @Size(min = 2, max = 3)
    private String country;
    @NotBlank
    @Size(min = 2)
    private String city;

    public WeatherInfoDtoId() {
    }

    public WeatherInfoDtoId(String country,String city) {
        this.country = country;
        this.city = city;
    }

    @Column(name = "country", nullable = false)
    public String getCountry() {
        return country;
    }

    @Column(name = "city", nullable = false)
    public String getCity() {
        return city;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherInfoId that = (WeatherInfoId) o;
        return Objects.equals(country, that.country) && Objects.equals(city, that.city);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }
}
