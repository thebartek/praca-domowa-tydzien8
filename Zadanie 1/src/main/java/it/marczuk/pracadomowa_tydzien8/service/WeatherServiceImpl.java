package it.marczuk.pracadomowa_tydzien8.service;

import it.marczuk.pracadomowa_tydzien8.dto.WeatherDto;
import it.marczuk.pracadomowa_tydzien8.model.Weather;
import it.marczuk.pracadomowa_tydzien8.repository.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    private WeatherRepo repo;

    @Autowired
    public WeatherServiceImpl(WeatherRepo repo) {
        this.repo = repo;
    }

    @Override
    public Weather getWeather() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://api.weatherapi.com/v1/current.json?key=ab6b5e968d8e4350a4e165036210303&q=Warsaw", Weather.class);
    }

    @Override
    public WeatherDto convertWeather() {
        Weather weatherApi = getWeather();
        return new WeatherDto(weatherApi.getCurrent().getTempC(), weatherApi.getCurrent().getWindKph(), weatherApi.getCurrent().getCloud(), weatherApi.getLocation().getLocaltime());
    }

    @Override
    @Scheduled(cron = "0 0 */1 * * *")
    public void saveWeatherToDataBase() {
        repo.save(convertWeather());
    }
}
