package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.WeatherDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SysTester {

    private WeatherDTO weatherQuery;
    private RequestHandler requestHandler;

    @BeforeEach
    public void setUp() {
        requestHandler = new RequestHandler("weather?q=London,uk");
        weatherQuery = requestHandler.createResult();
    }


    @Test
    public void testSysTypeType() {
        Assertions.assertEquals(Integer.class, weatherQuery.getSys().getType().getClass());
    }

    @Test
    public void testSysIdType() {
        Assertions.assertEquals(Integer.class, weatherQuery.getSys().getId().getClass());
    }


    @Test
    public void testSysCountryType() {
        Assertions.assertEquals(String.class, weatherQuery.getSys().getCountry().getClass());
    }

    @Test
    public void testSysSunriseType() {
        Assertions.assertEquals(Integer.class, weatherQuery.getSys().getSunrise().getClass());
    }

    @Test
    public void testSysSunsetType() {
        Assertions.assertEquals(Integer.class, weatherQuery.getSys().getSunset().getClass());
    }
}
