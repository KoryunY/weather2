package com.gmail.yeritsyankoryun.weather.service;

import com.gmail.yeritsyankoryun.weather.dto.WeatherInfoDto;
import com.gmail.yeritsyankoryun.weather.model.WeatherInfoId;
import com.gmail.yeritsyankoryun.weather.model.WeatherInfoModel;
import com.gmail.yeritsyankoryun.weather.repository.WeatherRepository;
import com.gmail.yeritsyankoryun.weather.service.converter.WeatherConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {
    private final WeatherConverter weatherConverter;
    private final WeatherRepository repository;
    @Autowired
    public WeatherService(WeatherConverter weatherConverter, WeatherRepository repository) {
        this.weatherConverter = weatherConverter;
        this.repository = repository;
    }

    public List<WeatherInfoDto> getWeatherInfo(String country, String city) {
        if (country == null && city == null)
            return repository.findAll().stream().map(weatherConverter::convertToDto)
                    .collect(Collectors.toList());
        else if (country == null || city == null) {
            throw  new IllegalArgumentException("NUll",new Throwable(city==null?"City":"Country"));
        }
        return repository.findAll().stream()
                .filter(weather -> weather.equals(repository.getById(new WeatherInfoId(country,city))))
                .map(weatherConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public void addWeather(WeatherInfoDto dto) {
        repository.saveAndFlush(weatherConverter.convertToModel(dto));
    }

    public void updateWeather(WeatherInfoDto dto) {
        WeatherInfoModel temp = repository.getById(new WeatherInfoId(dto.getCountry(),dto.getCity()));
        if (dto.getTemperature() != null)
            temp.setTemperature(dto.getTemperature());
        if (dto.getWindSpeed() != null)
            temp.setWindSpeed(dto.getWindSpeed());
        if (dto.getType() != null)
            temp.setType(dto.getType());
    }

    public void delete(String country, String city) {
        if (country == null && city == null)
            repository.deleteAll();
        else if (country == null || city == null) {
            throw  new IllegalArgumentException("NUll",new Throwable(city==null?"City":"Country"));
        } else repository.deleteById(new WeatherInfoId(country,city));
    }
}
