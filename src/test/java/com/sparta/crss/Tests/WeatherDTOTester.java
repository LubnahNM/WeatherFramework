package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.Clouds;
import com.sparta.crss.JacksonClasses.Coord;
import com.sparta.crss.JacksonClasses.WeatherDTO;
import com.sparta.crss.JacksonClasses.Wind;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherDTOTester {
    private RequestHandler requestHandler;
    public WeatherDTO weatherDTO;

    @BeforeEach
    public void setUp() {
        String s = "weather?q=London,uk";
        //String s = "weather?q=new%20york";
        //String s = "weather?q=Belokurikha";
        requestHandler = new RequestHandler(s);
        weatherDTO = requestHandler.createResult();
    }

    @Test
    public void testVisibility() {
        Assertions.assertEquals(Integer.class, weatherDTO.getVisibility().getClass());
    }

    @Test
    public void testDt() {
        Assertions.assertEquals(Integer.class, weatherDTO.getDt().getClass());
    }

    @Test
    public void testId() {
        Assertions.assertEquals(Integer.class, weatherDTO.getId().getClass());
    }

    @Test
    public void testCod() {
        Assertions.assertEquals(Integer.class, weatherDTO.getCod().getClass());
    }

    @Test
    public void testName() {
        Assertions.assertEquals(String.class, weatherDTO.getName().getClass());
    }

    @Test
    public void testBase() {
        Assertions.assertEquals(String.class, weatherDTO.getBase().getClass());
    }

    @Test
    public void testTimezone() {
//        requestHandler.updateRequest("weather?lat=35&lon=139");
//        weatherDTO = requestHandler.createResult();
        Assertions.assertEquals(Integer.class, weatherDTO.getTimezone().getClass());
    }

    @Test
    public void testWeather() {
        Assertions.assertEquals(ArrayList.class, weatherDTO.getWeather().getClass());
    }

    @Test
    public void testMain() {
        Assertions.assertEquals(String.class, weatherDTO.getWeather().get(0).getMain().getClass());
    }

    @Test
    public void testDescription() {
        Assertions.assertEquals(String.class, weatherDTO.getWeather().get(0).getDescription().getClass());
    }

    @Test
    public void testIcon() {
        Assertions.assertEquals(String.class, weatherDTO.getWeather().get(0).getIcon().getClass());
    }

    @Test
    @DisplayName("checks the temperature")
    public void checkTemperature() {
        assertEquals(java.lang.Double.class, weatherDTO.getMain().getTemp().getClass());
    }

    @Test
    @DisplayName("checks the minimum temp")
    public void checkMinTemp() {
        assertEquals(java.lang.Double.class, weatherDTO.getMain().getTempMin().getClass());
    }

    @Test
    @DisplayName("checks the maximum temp")
    public void checkMaxTemp() {
        assertEquals(java.lang.Double.class, weatherDTO.getMain().getTempMax().getClass());
    }

    @Test
    @DisplayName("checks the pressure")
    public void checkPressure() {
        assertEquals(java.lang.Integer.class, weatherDTO.getMain().getPressure().getClass());
    }

    @Test
    @DisplayName("checks the humidity")
    public void checkHumidity() {
        assertEquals(java.lang.Integer.class, weatherDTO.getMain().getHumidity().getClass());
    }

    @Test
    @DisplayName("checks coord")
    public void testCoord() {
        Assertions.assertEquals(Coord.class, weatherDTO.getCoord().getClass());
    }

    @Test
    @DisplayName("checks Longitude")
    public void testLongitude() {
        Assertions.assertEquals(Double.class, weatherDTO.getCoord().getLon().getClass());
    }

    @Test
    public void testLatitude() {
        Assertions.assertEquals(Double.class, weatherDTO.getCoord().getLat().getClass());
    }

    @Test
    public void checkCorrectClass() {
        Assertions.assertEquals(Wind.class, weatherDTO.getWind().getClass());
    }

    @Test
    public void checkIfNotNull() {
        //System.out.println(weatherQuery.getList().get(0).getWind().getDeg());
        Assertions.assertTrue(weatherDTO.getWind().getClass() != null);
    }

    @Test
    public void checkIfWindSpeedNotNull() {
        Assertions.assertTrue(weatherDTO.getWind().getSpeed() != null);
    }

    @Test
    public void checkIfWindDegNotNull() {
        //System.out.println(weatherQuery.getList().get(0).getWind().getDeg());
        Assertions.assertTrue(weatherDTO.getWind().getDeg() != null);
    }

    @Test
    public void checkIfWindSpeedIsDouble() {
        Assertions.assertEquals(Double.class, weatherDTO.getWind().getSpeed().getClass());
    }

    @Test
    public void checkIfWindDegIsInteger() {
        Assertions.assertEquals(Integer.class, weatherDTO.getWind().getDeg().getClass());
    }

    @Test
    public void checkWindSpeedIsAcceptableRange() {
        Assertions.assertTrue(weatherDTO.getWind().getSpeed() >= 0);
    }

    @Test
    public void checkWindDegIsAcceptableRange() {
        Assertions.assertTrue(weatherDTO.getWind().getDeg() < 360);
    }

    @Test
    public void checkCloudClass() {
        Assertions.assertEquals(Clouds.class, weatherDTO.getClouds().getClass());
    }

    @Test
    public void checkCloudClassIfNotNull() {
        Assertions.assertTrue(weatherDTO.getClouds().getClass() != null);
    }

    @Test
    public void checkIfCloudsIsInteger() {
        Assertions.assertEquals(Integer.class, weatherDTO.getClouds().getAll().getClass());
    }

    @Test
    public void checkAllIsAcceptableRange() {
        Assertions.assertTrue(weatherDTO.getClouds().getAll() >= 0);
    }

    @Test
    public void testSysTypeType() {
        Assertions.assertEquals(Integer.class, weatherDTO.getSys().getType().getClass());
    }

    @Test
    public void testSysIdType() {
        Assertions.assertEquals(Integer.class, weatherDTO.getSys().getId().getClass());
    }


    @Test
    public void testSysCountryType() {
        Assertions.assertEquals(String.class, weatherDTO.getSys().getCountry().getClass());
    }

    @Test
    public void testSysSunriseType() {
        Assertions.assertEquals(Integer.class, weatherDTO.getSys().getSunrise().getClass());
    }

    @Test
    public void testSysSunsetType() {
        Assertions.assertEquals(Integer.class, weatherDTO.getSys().getSunset().getClass());
    }

    @Test
    public void testRain() {
        if (weatherDTO.getRain() == null) {
            Assertions.assertNull(weatherDTO.getRain());
        } else {
            Assertions.assertEquals(Double.class, weatherDTO.getRain().get1h().getClass());
        }
    }

    @Test
    public void testSnow() {
        if (weatherDTO.getSnow() == null) {
            Assertions.assertNull(weatherDTO.getSnow());
        } else {
            Assertions.assertEquals(Double.class, weatherDTO.getSnow().get3h().getClass());
        }
    }
}
