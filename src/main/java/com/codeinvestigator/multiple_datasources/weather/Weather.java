package com.codeinvestigator.multiple_datasources.weather;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column
    private String weatherforecast;
    @Column
    private String targetday;

    public static Weather of(String forecast, String day){
        Weather weather = new Weather();
        weather.targetday = day;
        weather.weatherforecast = forecast;
        return weather;
    }
}
