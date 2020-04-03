package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.MultiWeatherDTOJackson;
import com.sparta.crss.JacksonClasses.Wind;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WindTester {

    MultiWeatherDTOJackson weatherQuery = new MultiWeatherDTOJackson();
    RequestHandler requestHandler;
    boolean isMetric;

    @BeforeEach
    public void setUp() {
        String url = "find?lat=55.5&units=metric&lon=37.5&cnt=10";
        requestHandler = new RequestHandler(url);
        weatherQuery = requestHandler.createMultiResult();
        isMetric = url.contains("metric");
    }

    @Test
    public void checkCorrectClass() {
        Assertions.assertEquals(Wind.class, weatherQuery.getList().get(0).getWind().getClass());
    }
    @Test
    public void checkIfNotNull() {
        System.out.println(weatherQuery.getList().get(0).getWind().getDeg());
        Assertions.assertTrue(weatherQuery.getList().get(0).getWind().getClass() != null);
    }
    @Test
    public void checkIfWindSpeedNotNull() {
        Assertions.assertTrue(weatherQuery.getList().get(0).getWind().getSpeed() != null);
    }
    @Test
    public void checkIfWindDegNotNull() {
        System.out.println(weatherQuery.getList().get(0).getWind().getDeg());
        Assertions.assertTrue(weatherQuery.getList().get(0).getWind().getDeg() != null);
    }
    @Test
    public void checkIfWindSpeedIsDouble() {
        Assertions.assertEquals(Double.class, weatherQuery.getList().get(0).getWind().getSpeed().getClass());
    }
    @Test
    public void checkIfWindDegIsInteger() {
        Assertions.assertEquals(Integer.class, weatherQuery.getList().get(0).getWind().getDeg().getClass());
    }
    @Test
    public void checkWindSpeedIsAcceptableRange() {
        Assertions.assertTrue(weatherQuery.getList().get(0).getWind().getSpeed() >= 0);
    }
    @Test
    public void checkWindDegIsAcceptableRange() {
        Assertions.assertTrue(weatherQuery.getList().get(0).getWind().getDeg() < 360);
    }
}
