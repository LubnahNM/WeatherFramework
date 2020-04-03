package com.sparta.crss;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.MultiWeatherDTOJackson;
import com.sparta.crss.JacksonClasses.WeatherDTOJackson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJames {

    WeatherDTOJackson weatherQuery = new WeatherDTOJackson();
    RequestHandler requestHandler;

//    timezone Shift in seconds from UTC
//    id City ID
//    name City name
//    cod Internal parameter

    @BeforeEach
    public void setUp() {

        requestHandler = new RequestHandler("find?lat=55.5&units=metric&lon=37.5&cnt=10");
        weatherQuery = requestHandler.createResult();

    }

    @Test
    public void testTimeShift(){
       assertEquals(Integer.class, weatherQuery.getTimezone().getClass());
    }
}
