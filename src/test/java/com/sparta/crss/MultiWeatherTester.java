package com.sparta.crss;


import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.MultiWeatherDTOJackson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class MultiWeatherTester {

    MultiWeatherDTOJackson weatherQuery = new MultiWeatherDTOJackson();
    RequestHandler requestHandler;

    @BeforeEach
    public void setUp() {
        requestHandler = new RequestHandler("find?lat=55.5&units=metric&lon=37.5&cnt=10");
        weatherQuery = requestHandler.createMultiResult();
    }

    @Test
    public void checkSuccessfulConnection() {
        System.out.println( weatherQuery.getMessage());
        Assertions.assertEquals(String.class, weatherQuery.getMessage().getClass());
    }

    @Test
    public void checkQuestionType() {
        //Assertions.assertEquals("boolean",weatherQuery.getResults().get(0).getType());
    }
}
