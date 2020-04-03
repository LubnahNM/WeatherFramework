package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.MultiWeatherDTO;
import com.sparta.crss.JacksonClasses.WeatherDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTester {
    WeatherDTO weatherQuery = new WeatherDTO();
    RequestHandler requestHandler;
    //boolean isMetric
    @BeforeEach
    @Test
    public void setUp() {
        requestHandler = new RequestHandler("weather?q=London,uk");
        weatherQuery = requestHandler.createResult();
        // isMetric = url.contains("metric");
    }
    @Test
    @DisplayName("checks the temperature")
    public void checkTemperature(){
        assertEquals(java.lang.Double.class, weatherQuery.getMain().getTemp().getClass());
    }
    @Test
    @DisplayName("checks the minimum temp")
    public void checkMinTemp(){
        assertEquals(java.lang.Double.class, weatherQuery.getMain().getTempMin().getClass());
    }
    @Test
    @DisplayName("checks the maximum temp")
    public void checkMaxTemp(){
        assertEquals(java.lang.Double.class, weatherQuery.getMain().getTempMax().getClass());
    }
    @Test
    @DisplayName("checks the pressure")
    public void checkPressure(){
        assertEquals(java.lang.Integer.class, weatherQuery.getMain().getPressure().getClass());
    }
    @Test
    @DisplayName("checks the humidity")
    public void checkHumidity(){
        assertEquals(java.lang.Integer.class, weatherQuery.getMain().getHumidity().getClass());
    }
}
