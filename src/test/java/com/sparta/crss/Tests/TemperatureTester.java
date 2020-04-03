package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.MultiWeatherDTOJackson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TemperatureTester {
    MultiWeatherDTOJackson weatherQuery = new MultiWeatherDTOJackson();
    RequestHandler requestHandler;
    //boolean isMetric
    @BeforeEach
    @Test
    public void setUp() {
        requestHandler = new RequestHandler("find?lat=55.5&units=metric&lon=37.5&cnt=10");
        weatherQuery = requestHandler.createMultiResult();
        // isMetric = url.contains("metric");
    }
    @Test
    @DisplayName("checks the temperature")
    public void checkTemperature(){
        assertEquals(java.lang.Double.class, weatherQuery.getList().get(0).getMain().getTemp().getClass());
    }
    @Test
    @DisplayName("checks the minimum temp")
    public void checkMinTemp(){
        assertEquals(java.lang.Double.class, weatherQuery.getList().get(0).getMain().getTempMin().getClass());
    }
    @Test
    @DisplayName("checks the maximum temp")
    public void checkMaxTemp(){
        assertEquals(java.lang.Double.class, weatherQuery.getList().get(0).getMain().getTempMax().getClass());
    }
    @Test
    @DisplayName("checks the pressure")
    public void checkPressure(){
        assertEquals(java.lang.Integer.class, weatherQuery.getList().get(0).getMain().getPressure().getClass());
    }
    @Test
    @DisplayName("checks the humidity")
    public void checkHumidity(){
        assertEquals(java.lang.Integer.class, weatherQuery.getList().get(0).getMain().getHumidity().getClass());
    }
}

