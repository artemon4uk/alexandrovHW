package ru.sbt.course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {
    Optional<Weather> findByCityAndDate(String city, LocalDate date);
}
