package com.gmail.yeritsyankoryun.weather.service;

import com.gmail.yeritsyankoryun.weather.dao.WeatherDataAccessService;
import com.gmail.yeritsyankoryun.weather.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherService {
    private final WeatherDataAccessService weatherDataAccessService;

    @Autowired
    public WeatherService(WeatherDataAccessService weatherDataAccessService) {
        this.weatherDataAccessService = weatherDataAccessService;
    }
    public List<Weather> getAllWeather(){
        return weatherDataAccessService.selectAllWeather();
    }

    public Optional<Weather> getByCC(String country, String city){
        return weatherDataAccessService.selectByCC( country, city);
    }
    public int addWeather(Weather weather){
        return weatherDataAccessService.insertWeather(weather);
    }
    public void deleteAll(){
        weatherDataAccessService.deleteAll();
    }
}
