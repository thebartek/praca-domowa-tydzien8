package it.marczuk.pracadomowa_tydzien8.repository;

import it.marczuk.pracadomowa_tydzien8.dto.WeatherDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepo extends JpaRepository<WeatherDto, Long> {
}
