package it.marczuk.pracadomowa_tydzien8.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "weathers")
public class WeatherDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double temp;
    private double wind;
    private int claud;
    private String localTime;

    public WeatherDto(double temp, double wind, int claud, String localTime) {
        this.temp = temp;
        this.wind = wind;
        this.claud = claud;
        this.localTime = localTime;
    }
}
