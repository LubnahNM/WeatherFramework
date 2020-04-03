package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.Clouds;
import com.sparta.crss.JacksonClasses.MultiWeatherDTO;

import com.sparta.crss.JacksonClasses.WeatherDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CloudsTester {
    WeatherDTO weatherQuery = new WeatherDTO();
    RequestHandler requestHandler;
    boolean isMetric;

    @BeforeEach
    public void setUp() {
        String url = "weather?q=London,uk";
        requestHandler = new RequestHandler(url);
        weatherQuery = requestHandler.createResult();
    }

    @Test
    public void checkCorrectClass() {
        Assertions.assertEquals(Clouds.class, weatherQuery.getClouds().getClass());
    }
    @Test
    public void checkIfNotNull() {
        Assertions.assertTrue(weatherQuery.getClouds().getClass() != null);
    }

    @Test
    public void checkIfCloudsIsInteger() {
        Assertions.assertEquals(Integer.class, weatherQuery.getClouds().getAll().getClass());
    }
    @Test
    public void checkAllIsAcceptableRange() {
        Assertions.assertTrue(weatherQuery.getClouds().getAll() >= 0);
    }
}
