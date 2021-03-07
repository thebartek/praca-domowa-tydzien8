package it.marczuk.pracadomowa_tydzien8.service;

import it.marczuk.pracadomowa_tydzien8.dto.WeatherDto;
import it.marczuk.pracadomowa_tydzien8.model.Weather;

public interface WeatherService {

    Weather getWeather();

    WeatherDto convertWeather();

    void saveWeatherToDataBase();
}
