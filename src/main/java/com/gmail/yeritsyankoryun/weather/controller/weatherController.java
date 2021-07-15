package com.gmail.yeritsyankoryun.weather.controller;

import com.gmail.yeritsyankoryun.weather.model.Weather;
import com.gmail.yeritsyankoryun.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/weather")
public class weatherController {
    private final WeatherService weatherService;

    @Autowired
    public weatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public List<Weather> getAllWeather(){
        return weatherService.getAllWeather();
    }
    @GetMapping(path = "{country}/{city}")
    public int getTempByCC(@PathVariable("country") String country,@PathVariable("city") String city){
        return weatherService.getByCC(country,city).get().getTemperature();
    }
    @PostMapping
    public void add(@RequestBody Weather weather){
        weatherService.addWeather(weather);
    }
    @PutMapping(path = "{country}/{city}")
    public void updateTemp(@PathVariable("country") String country,@PathVariable("city") String city,@RequestBody int temp){
        weatherService.getByCC(country,city).get().setTemperature(temp);
    }
    @DeleteMapping
    public void delete(){
        weatherService.deleteAll();
    }
}
