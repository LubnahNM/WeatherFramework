package com.sparta.crss;

import static org.junit.Assert.assertTrue;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.DataTransfer.DTO;
import com.sparta.crss.DataTransfer.MultiWeatherDTO;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String myQuery = "find?lat=55.5&units=metric&lon=37.5&cnt=10";
        RequestHandler requestHandler = new RequestHandler();
        MultiWeatherDTO wtd = requestHandler.checkURL(myQuery);
        assertTrue( true );
    }
}
