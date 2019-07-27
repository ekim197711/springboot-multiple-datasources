package com.codeinvestigator.multiple_datasources.weather;

import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<Weather, Integer> {

}
