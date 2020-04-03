package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.Coord;
import com.sparta.crss.JacksonClasses.WeatherDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoordTester {
    RequestHandler requestHandler;
    WeatherDTO weatherDTO;
    @BeforeEach
    public void setUp(){
        String s = "weather?q=London,uk";
        requestHandler = new RequestHandler(s);
        weatherDTO = requestHandler.createResult();
    }

    @Test
    public void testCoord(){
        Assertions.assertEquals(Coord.class, weatherDTO.getCoord().getClass());
    }

    @Test
    public void testLongitude(){
        Assertions.assertEquals(Double.class, weatherDTO.getCoord().getLon().getClass());
    }

    @Test
    public void testLatitude(){
        Assertions.assertEquals(Double.class, weatherDTO.getCoord().getLat().getClass());
    }
}
