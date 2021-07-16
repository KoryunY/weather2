package com.gmail.yeritsyankoryun.weather.model;

public enum WeatherType {
    SUNNY("sun"),
    CLOUDY("cld"),
    RAIN("rin"),
    SNOW("asd"),
    FOG("asd");
    String name;

    WeatherType(String name) {
        this.name = name;
    }
}
