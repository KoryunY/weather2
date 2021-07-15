package com.gmail.yeritsyankoryun.weather.dao;

import com.gmail.yeritsyankoryun.weather.model.Weather;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WeatherDataAccessService {
    private static List<Weather> weathers = new ArrayList<>();

    static {
        weathers.add(new Weather("Arm", "Yerevan", 37));
        weathers.add(new Weather("Arm", "Abovyan", 27));

    }

    public List<Weather> selectAllWeather() {
        return weathers;
    }

    public Optional<Weather> selectByCC(String country, String city) {
        return weathers.stream().filter(weather -> weather.getCity().equals(city) && weather.getCountry().equals(country)).findFirst();
    }
    public int insertWeather(Weather weather){
        weathers.add(weather);
        return 1;
    }
    public void deleteAll(){
        weathers.clear();
    }
}
