package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.Coord;
import com.sparta.crss.JacksonClasses.WeatherDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeatherDTOTester {
    RequestHandler requestHandler;
    WeatherDTO weatherDTO;
    @BeforeEach
    public void setUp(){
        String s = "weather?q=London,uk";
        requestHandler = new RequestHandler(s);
        weatherDTO = requestHandler.createResult();
    }

    @Test
    public void testVisibility(){
        Assertions.assertEquals(Integer.class, weatherDTO.getVisibility().getClass());
    }
    @Test
    public void testDt(){
        Assertions.assertEquals(Integer.class, weatherDTO.getDt().getClass());
    }
    @Test
    public void testId(){
        Assertions.assertEquals(Integer.class, weatherDTO.getId().getClass());
    }
    @Test
    public void testCod(){
        Assertions.assertEquals(Integer.class, weatherDTO.getCod().getClass());
    }
    @Test
    public void testName(){
        Assertions.assertEquals(String.class, weatherDTO.getName().getClass());
    }
    @Test
    public void testBase(){
        Assertions.assertEquals(String.class, weatherDTO.getBase().getClass());
    }
    @Test
    public void testTimezone(){
        requestHandler.updateRequest("weather?lat=35&lon=139");
        weatherDTO = requestHandler.createResult();
        Assertions.assertEquals(Integer.class, weatherDTO.getTimezone().getClass());
    }
}
