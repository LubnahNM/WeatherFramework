package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.Clouds;
import com.sparta.crss.JacksonClasses.MultiWeatherDTOJackson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CloudTester {
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
        Assertions.assertEquals(Clouds.class, weatherQuery.getList().get(0).getClouds().getClass());
    }
    @Test
    public void checkIfNotNull() {
        Assertions.assertTrue(weatherQuery.getList().get(0).getClouds().getClass() != null);
    }

    @Test
    public void checkIfCloudsIsInteger() {
        Assertions.assertEquals(Integer.class, weatherQuery.getList().get(0).getClouds().getAll().getClass());
    }
    @Test
    public void checkAllIsAcceptableRange() {
        Assertions.assertTrue(weatherQuery.getList().get(0).getClouds().getAll() >= 0);
    }
}
