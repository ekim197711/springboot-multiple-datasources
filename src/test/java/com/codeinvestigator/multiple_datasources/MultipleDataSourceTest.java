package com.codeinvestigator.multiple_datasources;

import com.codeinvestigator.multiple_datasources.sport.SportEvent;
import com.codeinvestigator.multiple_datasources.sport.SportEventRepository;
import com.codeinvestigator.multiple_datasources.weather.Weather;
import com.codeinvestigator.multiple_datasources.weather.WeatherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MultipleDataSourceTest {

    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    SportEventRepository sportEventRepository;

    @Test
    void testRepo(){
        sportEventRepository.deleteAll();
        weatherRepository.deleteAll();


        sportEventRepository.save(SportEvent.of("Curling", "Sweep the floor and yell"));
        sportEventRepository.save(SportEvent.of("Football", "Kick a ball around on a grass field."));

        weatherRepository.save(Weather.of("Cloudy", "Day after tomorrow"));
        weatherRepository.save(Weather.of("Snow", "In 5 days"));

        long countWeather = weatherRepository.count();
        long countSport = sportEventRepository.count();

        assertEquals(2, countWeather);
        assertEquals(2, countSport);
    }

}
