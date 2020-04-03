package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.MultiWeatherDTO;
import com.sparta.crss.JacksonClasses.WeatherDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultiWeatherDTOTester {
    RequestHandler requestHandler;
    MultiWeatherDTO multiWeatherDTO;
    @BeforeEach
    public void setUp(){
        String s = "/find?lat=55.5&lon=37.5&cnt=10";
        requestHandler = new RequestHandler(s);
        multiWeatherDTO = requestHandler.createMultiResult();
    }

    @Test
    public void testMessage(){
        Assertions.assertEquals(String.class, multiWeatherDTO.getMessage().getClass());
    }

    @Test
    public void testCod(){
        Assertions.assertEquals(String.class, multiWeatherDTO.getCod().getClass());
    }

    @Test
    public void testCount(){
        Assertions.assertEquals(Integer.class, multiWeatherDTO.getCount().getClass());
    }

    @Test
    public void testCnt(){
        requestHandler.updateRequest("box/city?bbox=12,32,15,37,10");
        multiWeatherDTO = requestHandler.createMultiResult();
        Assertions.assertEquals(Integer.class, multiWeatherDTO.getCnt().getClass());
    }

    @Test
    public void testCalctime(){
        requestHandler.updateRequest("box/city?bbox=12,32,15,37,10");
        multiWeatherDTO = requestHandler.createMultiResult();
        Assertions.assertEquals(Double.class, multiWeatherDTO.getCalctime().getClass());
    }


}
