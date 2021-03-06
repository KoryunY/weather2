package com.gmail.yeritsyankoryun.weather.service;

import com.gmail.yeritsyankoryun.weather.dto.WeatherInfoDto;
import com.gmail.yeritsyankoryun.weather.model.WeatherInfoId;
import com.gmail.yeritsyankoryun.weather.model.WeatherInfoModel;
import com.gmail.yeritsyankoryun.weather.model.WeatherType;
import com.gmail.yeritsyankoryun.weather.repository.WeatherRepository;
import com.gmail.yeritsyankoryun.weather.service.converter.WeatherConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WeatherServiceTest {
    WeatherConverter weatherConverter = new WeatherConverter();
    WeatherRepository weatherRepository = Mockito.mock(WeatherRepository.class);
    WeatherService weatherService = new WeatherService(weatherConverter, weatherRepository);

    public List<WeatherInfoModel> getAll() {
        List<WeatherInfoModel> weatherInfoList = new ArrayList<>();
        weatherInfoList.add(new WeatherInfoModel("Arm", "Yerevan", 17.1, WeatherType.RAIN, 20));
        weatherInfoList.add(new WeatherInfoModel("Usa", "New York", 22.2, WeatherType.FOG, 15));
        weatherInfoList.add(new WeatherInfoModel("Ru", "Moscow", 39.9, WeatherType.SUNNY, 5));
        weatherInfoList.add(new WeatherInfoModel("France", "Paris", 39.9, WeatherType.SNOW, 19));
        return weatherInfoList;
    }

    @DisplayName("Get Function Test")
    @Test
    void getWeatherInfo() {
        String country = "Ru";
        String city = "Moscow";
        when(weatherRepository.findAll()).thenReturn(getAll());
        when(weatherRepository.existsById(new WeatherInfoId(country, city))).thenReturn(false);

        Assertions.assertThrows(IllegalArgumentException.class, () -> weatherService.getWeatherInfo(country, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> weatherService.getWeatherInfo(null, city));
        Assertions.assertThrows(UnsupportedOperationException.class, () -> weatherService.getWeatherInfo(country, city));
    }

    @DisplayName("Update Test")
    @Test
    void updateWeather() {
        WeatherInfoDto dto = new WeatherInfoDto("Ru", "Moscow", 15.0, WeatherType.RAIN, 11);
        when(weatherRepository.existsById(new WeatherInfoId("Ru", "Sochi"))).thenReturn(false);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> weatherService.updateWeather(dto));
    }

    @DisplayName("Delete Test")
    @Test
    void delete() {
        WeatherInfoDto dto = new WeatherInfoDto("Ru", "Moscow", 15.0, WeatherType.RAIN, 11);
        when(weatherRepository.existsById(new WeatherInfoId("Ru", "Sochi"))).thenReturn(false);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> weatherService.updateWeather(dto));
    }

}