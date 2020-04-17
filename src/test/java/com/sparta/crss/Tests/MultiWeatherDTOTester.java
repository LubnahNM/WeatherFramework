package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.MultiWeatherDTO;
import com.sparta.crss.JacksonClasses.WeatherDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MultiWeatherDTOTester {
    private static RequestHandler requestHandler;
    private static MultiWeatherDTO multiWeatherDTO;
    @BeforeAll
    public static void setUp(){
        //String multiQuery = "find?lat=55.5&lon=37.5&cnt=10";
        //String multiQuery = "box/city?bbox=12,32,15,37,10";
        String multiQuery = "group?id=524901,703448,2643743&units=metric";
        requestHandler = new RequestHandler(multiQuery);
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
        if (multiWeatherDTO.getCod() == null) {
            Assertions.assertNull(multiWeatherDTO.getCod());
        } else {
            Assertions.assertEquals(String.class, multiWeatherDTO.getCod().getClass());
        }
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
       checkEachWeatherDTO(multiWeatherDTO.getList());
    }

    public void checkEachWeatherDTO(List<WeatherDTO> listOfAllWeather){
        if(listOfAllWeather == null) {
            return;
        }

        WeatherDTOTester weatherDTOTester = new WeatherDTOTester();
        for (WeatherDTO eachWeather: listOfAllWeather) {
            weatherDTOTester.setWeatherDTO(eachWeather);
            weatherDTOTester.runAllTests();
        }

    }
}
