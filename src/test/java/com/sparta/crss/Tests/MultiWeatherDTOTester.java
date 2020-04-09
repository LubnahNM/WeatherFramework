package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.MultiWeatherDTO;
import com.sparta.crss.JacksonClasses.WeatherDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MultiWeatherDTOTester {
    RequestHandler requestHandler;
    MultiWeatherDTO multiWeatherDTO;
    @BeforeEach
    public void setUp(){
        String s = "/find?lat=55.5&lon=37.5&cnt=10";
        //String s = "box/city?bbox=12,32,15,37,10";
        requestHandler = new RequestHandler(s);
        multiWeatherDTO = requestHandler.createMultiResult();
    }

    @Test
    public void testMessage(){
        if (multiWeatherDTO.getMessage() == null) {
            Assertions.assertNull(multiWeatherDTO.getMessage());
        } else {
            Assertions.assertEquals(String.class, multiWeatherDTO.getMessage().getClass());
        }
    }

    @Test
    public void testCod(){
        Assertions.assertEquals(String.class, multiWeatherDTO.getCod().getClass());
    }

    @Test
    public void testCount(){
        if (multiWeatherDTO.getCount() == null) {
            Assertions.assertNull(multiWeatherDTO.getCount());
        } else {
            Assertions.assertEquals(Integer.class, multiWeatherDTO.getCount().getClass());
        }
    }

    @Test
    public void testCnt(){
        if (multiWeatherDTO.getCnt() == null) {
            Assertions.assertNull(multiWeatherDTO.getCnt());
        } else {
            Assertions.assertEquals(Integer.class, multiWeatherDTO.getCnt().getClass());
        }

    }

    @Test
    public void testCalctime(){
        if (multiWeatherDTO.getCalctime() == null) {
            Assertions.assertNull(multiWeatherDTO.getCalctime());
        } else {
            Assertions.assertEquals(Double.class, multiWeatherDTO.getCalctime().getClass());
        }

    }
    @Test
    public void testAllListTimes(){
        Assertions.assertTrue(checkEachOfWeatherDTO(multiWeatherDTO.getList()));
    }

    public boolean checkEachOfWeatherDTO(List<WeatherDTO> listOfAllWeather){
        if(listOfAllWeather == null) {
            return false;
        }

        WeatherDTOTester weatherDTOTester = new WeatherDTOTester();
        for (WeatherDTO eachWeather: listOfAllWeather) {
            weatherDTOTester.weatherDTO = eachWeather;
        }
        return true;
    }
}
