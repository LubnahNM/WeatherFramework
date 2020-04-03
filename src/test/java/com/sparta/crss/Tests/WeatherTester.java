package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.Coord;
import com.sparta.crss.JacksonClasses.WeatherDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class WeatherTester {

    RequestHandler requestHandler;
    WeatherDTO weatherDTO;
    @BeforeEach
    public void setUp(){
        String s = "weather?q=London,uk";
        requestHandler = new RequestHandler(s);
        weatherDTO = requestHandler.createResult();
    }

    @Test
    public void testWeather(){
        Assertions.assertEquals(ArrayList.class, weatherDTO.getWeather().getClass());
    }

    @Test
    public void testMain(){
        Assertions.assertEquals(String.class, weatherDTO.getWeather().get(0).getMain().getClass());
    }

    @Test
    public void testDescription(){
        Assertions.assertEquals(String.class, weatherDTO.getWeather().get(0).getDescription().getClass());
    }

    @Test
    public void testIcon(){
        Assertions.assertEquals(String.class, weatherDTO.getWeather().get(0).getIcon().getClass());
    }
}
