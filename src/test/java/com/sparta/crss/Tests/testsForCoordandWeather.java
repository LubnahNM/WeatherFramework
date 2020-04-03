package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.Coord;
import com.sparta.crss.JacksonClasses.Weather;
import com.sparta.crss.JacksonClasses.WeatherDTOJackson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class testsForCoordandWeather {
    RequestHandler requestHandler;
    WeatherDTOJackson weatherDTOJackson;
    @BeforeEach
    public void setUp(){
        String s = "weather?q=London,uk";
        requestHandler = new RequestHandler(s);
        weatherDTOJackson = requestHandler.createResult();
    }

    @Test
    public void testCoord(){
        Assertions.assertEquals(Coord.class, weatherDTOJackson.getCoord().getClass());
    }

    @Test
    public void testLongitude(){
        Assertions.assertEquals(Double.class, weatherDTOJackson.getCoord().getLon().getClass());
    }

    @Test
    public void testLatitude(){
        Assertions.assertEquals(Double.class, weatherDTOJackson.getCoord().getLat().getClass());
    }

    @Test
    public void testWeather(){
        Assertions.assertEquals(ArrayList.class, weatherDTOJackson.getWeather().getClass());
    }

    @Test
    public void testMain(){
        Assertions.assertEquals(String.class, weatherDTOJackson.getWeather().get(0).getMain().getClass());
    }

    @Test
    public void testDescription(){
        Assertions.assertEquals(String.class, weatherDTOJackson.getWeather().get(0).getDescription().getClass());
    }

    @Test
    public void testIcon(){
        Assertions.assertEquals(String.class, weatherDTOJackson.getWeather().get(0).getIcon().getClass());
    }

}
