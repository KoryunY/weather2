package com.gmail.yeritsyankoryun.weather.dao;

import com.gmail.yeritsyankoryun.weather.model.WeatherInfoModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WeatherDataAccessService {
    private static List<WeatherInfoModel> weathers = new ArrayList<>();

    static {
        weathers.add(new WeatherInfoModel("Arm", "Yerevan", 37));
        weathers.add(new WeatherInfoModel("Arm", "Abovyan", 27));

    }

    public List<WeatherInfoModel> selectAllWeather() {
        return weathers;
    }

    public Optional<WeatherInfoModel> selectByCC(String country, String city) {
        return weathers.stream().filter(weather -> weather.getCity().equals(city) && weather.getCountry().equals(country)).findFirst();
    }
    public void insertWeather(WeatherInfoModel weather){
        weathers.add(weather);
    }
    public void deleteAll(){
        weathers.clear();
    }
}
