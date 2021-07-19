package com.gmail.yeritsyankoryun.weather.repository;

import com.gmail.yeritsyankoryun.weather.model.WeatherInfoId;
import com.gmail.yeritsyankoryun.weather.model.WeatherInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherInfoModel, WeatherInfoId> {
}
