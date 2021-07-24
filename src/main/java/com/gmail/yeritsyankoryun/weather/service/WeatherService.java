package com.gmail.yeritsyankoryun.weather.service;

import com.gmail.yeritsyankoryun.weather.dto.WeatherInfoDto;
import com.gmail.yeritsyankoryun.weather.model.WeatherInfoId;
import com.gmail.yeritsyankoryun.weather.model.WeatherInfoModel;
import com.gmail.yeritsyankoryun.weather.repository.WeatherRepository;
import com.gmail.yeritsyankoryun.weather.service.converter.WeatherConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
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
            throw new IllegalArgumentException("Cant access weather info without  " + (city == null ? "City" : "Country") + " field");
        }
        if (!repository.existsById(new WeatherInfoId(country, city)))
            throw new UnsupportedOperationException("Weather Info for " + country + " and " + city + "does not exists!.");
        List<WeatherInfoDto> weatherInfoDtoList = new ArrayList<>();
        WeatherInfoDto dto = weatherConverter.convertToDto(repository.getById(new WeatherInfoId(country, city)));
        weatherInfoDtoList.add(dto);
        return weatherInfoDtoList;
    }

    public void addWeather(WeatherInfoDto dto) {
        WeatherInfoModel model = weatherConverter.convertToModel(dto);
        String validationResult=addValidation(dto);
        if (validationResult == null)
            repository.save(model);
        else throw new IllegalArgumentException("Failed Validation for: "+validationResult+"\n"+"Message: should not be empty");
    }

    public void updateWeather(WeatherInfoDto dto) throws UnsupportedOperationException {
        if (repository.existsById(new WeatherInfoId(dto.getCountry(), dto.getCity()))) {
            WeatherInfoModel model = weatherConverter.convertToModel(dto);
            repository.save(model);
        } else
            throw new UnsupportedOperationException("Weather Info for " + dto.getCity() + " and " + dto.getCountry() + " does not exist!");
    }

    public void delete(String country, String city) throws IllegalArgumentException {
        if (country == null && city == null)
            repository.deleteAll();
        else if (country == null || city == null) {
            throw new IllegalArgumentException("Cant access weather info without  " + (city == null ? "City" : "Country") + " field.");
        } else repository.deleteById(new WeatherInfoId(country, city));
    }

    public String addValidation(WeatherInfoDto dto) {
        if (dto.getTemperature() == null) return "temperature";
        if (dto.getWindSpeed() == null) return "windSpeed";
        if (dto.getType() == null) return "type";
        return null;
    }
}
