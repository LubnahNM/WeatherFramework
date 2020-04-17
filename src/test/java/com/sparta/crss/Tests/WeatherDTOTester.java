package com.sparta.crss.Tests;

import com.sparta.crss.DataInjection.RequestHandler;
import com.sparta.crss.JacksonClasses.Clouds;
import com.sparta.crss.JacksonClasses.Coord;
import com.sparta.crss.JacksonClasses.WeatherDTO;
import com.sparta.crss.JacksonClasses.Wind;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WeatherDTOTester {
    private static RequestHandler requestHandler;
    private static WeatherDTO weatherDTO;

    @BeforeAll
    public static void setUp() {
        //String query = "weather?q=London,uk";
        //String query = "weather?q=new%20york";
        String query = "weather?q=Belokurikha";
        requestHandler = new RequestHandler(query);
        weatherDTO = requestHandler.createResult();
    }

    public WeatherDTO getWeatherDTO() {
        return weatherDTO;
    }

    public void setWeatherDTO(WeatherDTO weatherDTO) {
        WeatherDTOTester.weatherDTO = weatherDTO;
    }

    public void runAllTests(){
        testVisibility();
        testDt();
        testId();
        testCod();
        testName();
        testBase();
        testTimezone();
        testWeather();
        testMain();
        testDescription();
        testIcon();
        checkTemperature();
        checkMinTemp();
        checkMaxTemp();
        checkPressure();
        checkHumidity();
        testCoord();
        testLongitude();
        testLatitude();
        testCorrectWindClass();
        checkIfWindNotNull();
        checkIfWindSpeedNotNull();
        checkIfWindDegNotNull();
        checkIfWindSpeedIsDouble();
        checkIfWindDegIsInteger();
        checkWindSpeedIsAcceptableRange();
        checkWindDegIsAcceptableRange();
        checkCloudClass();
        checkCloudClassIfNotNull();
        checkIfCloudsIsInteger();
        checkAllIsAcceptableRange();
        testSysTypeType();
        testSysIdType();
        testSysCountryType();
        testSysSunriseType();
        testSysSunsetType();
        testRain();
        testSnow();
    }

    @Test
    public void testVisibility() {
        if (weatherDTO.getVisibility() == null) {
            Assertions.assertNull(weatherDTO.getVisibility());
        } else {
            Assertions.assertEquals(Integer.class, weatherDTO.getVisibility().getClass());
        }
    }

    @Test
    public void testDt() {
        if (weatherDTO.getDt() == null) {
            Assertions.assertNull(weatherDTO.getDt());
        } else {
            Assertions.assertEquals(Integer.class, weatherDTO.getDt().getClass());
        }
    }

    @Test
    public void testId() {
        if (weatherDTO.getId() == null) {
            Assertions.assertNull(weatherDTO.getId());
        } else {
            Assertions.assertEquals(Integer.class, weatherDTO.getId().getClass());
        }
    }

    @Test
    public void testCod() {
        if (weatherDTO.getCod() == null) {
            Assertions.assertNull(weatherDTO.getCod());
        } else {
            Assertions.assertEquals(Integer.class, weatherDTO.getCod().getClass());
        }
    }

    @Test
    public void testName() {
        if (weatherDTO.getName()== null) {
            Assertions.assertNull(weatherDTO.getName());
        } else {
            Assertions.assertEquals(String.class, weatherDTO.getName().getClass());
        }
    }

    @Test
    public void testBase() {
        if (weatherDTO.getBase() == null) {
            Assertions.assertNull(weatherDTO.getBase());
        } else {
            Assertions.assertEquals(String.class, weatherDTO.getBase().getClass());
        }
    }

    @Test
    public void testTimezone() {
        if (weatherDTO.getTimezone() == null) {
            Assertions.assertNull(weatherDTO.getTimezone());
        } else {
            Assertions.assertEquals(Integer.class, weatherDTO.getTimezone().getClass());
        }
    }

    @Test
    public void testWeather() {
        if (weatherDTO.getWeather() == null) {
            Assertions.assertNull(weatherDTO.getWeather());
        } else {
            Assertions.assertEquals(ArrayList.class, weatherDTO.getWeather().getClass());
        }
    }

    @Test
    public void testMain() {
        if (weatherDTO.getWeather().get(0).getMain() == null) {
            Assertions.assertNull(weatherDTO.getWeather().get(0).getMain());
        } else {
            Assertions.assertEquals(String.class, weatherDTO.getWeather().get(0).getMain().getClass());
        }
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
        if (weatherDTO.getCoord().getLon()== null) {
            Assertions.assertNull(weatherDTO.getCoord().getLon());
        } else {
            Assertions.assertEquals(Double.class, weatherDTO.getCoord().getLon().getClass());
        }
    }

    @Test
    public void testLatitude() {
        if (weatherDTO.getCoord().getLat()== null) {
            Assertions.assertNull(weatherDTO.getCoord().getLat());
        } else {
            Assertions.assertEquals(Double.class, weatherDTO.getCoord().getLat().getClass());
        }
    }

    @Test
    public void testCorrectWindClass() {
        if (weatherDTO.getWind()== null) {
            Assertions.assertNull(weatherDTO.getWind());
        } else {
            Assertions.assertEquals(Wind.class, weatherDTO.getWind().getClass());
        }

    }

    @Test
    public void checkIfWindNotNull() {
        if (weatherDTO.getWind().getClass() == null) {
            Assertions.assertNull(weatherDTO.getWind().getClass());
        } else {
            Assertions.assertNotNull(weatherDTO.getWind().getClass());
        }
    }

    @Test
    public void checkIfWindSpeedNotNull() {
        if (weatherDTO.getWind().getSpeed() == null) {
            Assertions.assertNull(weatherDTO.getWind().getSpeed());
        } else {
            Assertions.assertNotNull(weatherDTO.getWind().getSpeed());
        }
    }

    @Test
    public void checkIfWindDegNotNull() {
        if (weatherDTO.getWind().getDeg() == null) {
            Assertions.assertNull(weatherDTO.getWind().getDeg());
        } else {
            Assertions.assertNotNull(weatherDTO.getWind().getDeg());
        }
    }

    @Test
    public void checkIfWindSpeedIsDouble() {
        Assertions.assertEquals(Double.class, weatherDTO.getWind().getSpeed().getClass());
    }

    @Test
    public void checkIfWindDegIsInteger() {
        if (weatherDTO.getWind().getDeg() == null) {
            Assertions.assertNull(weatherDTO.getWind().getDeg());
        } else {
            Assertions.assertEquals(Integer.class, weatherDTO.getWind().getDeg().getClass());
        }

    }

    @Test
    public void checkWindSpeedIsAcceptableRange() {
        if (weatherDTO.getWind().getSpeed() == null) {
            Assertions.assertNull(weatherDTO.getWind().getSpeed());
        } else {
            Assertions.assertTrue(weatherDTO.getWind().getSpeed() >= 0);
        }

    }

    @Test
    public void checkWindDegIsAcceptableRange() {
        if (weatherDTO.getWind().getDeg() == null) {
            Assertions.assertNull(weatherDTO.getWind().getDeg());
        } else {
            Assertions.assertTrue(weatherDTO.getWind().getDeg() < 360);
        }
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
        if (weatherDTO.getClouds().getAll() == null) {
            Assertions.assertNull(weatherDTO.getClouds().getAll());
        } else {
            Assertions.assertEquals(Integer.class, weatherDTO.getClouds().getAll().getClass());
        }
    }

    @Test
    public void checkAllIsAcceptableRange() {
        if (weatherDTO.getClouds().getAll() == null) {
            Assertions.assertNull(weatherDTO.getClouds().getAll());
        } else {
            Assertions.assertTrue(weatherDTO.getClouds().getAll() >= 0);
        }
    }

    @Test
    public void testSysTypeType() {
        if (weatherDTO.getSys().getType() == null) {
            Assertions.assertNull(weatherDTO.getSys().getType());
        } else {
            Assertions.assertEquals(Integer.class, weatherDTO.getSys().getType().getClass());
        }
    }

    @Test
    public void testSysIdType() {
        if (weatherDTO.getSys().getId() == null) {
            Assertions.assertNull(weatherDTO.getSys().getId());
        } else {
            Assertions.assertEquals(Integer.class, weatherDTO.getSys().getId().getClass());
        }
    }


    @Test
    public void testSysCountryType() {
        if (weatherDTO.getSys() == null) {
            Assertions.assertNull(weatherDTO.getSys());
        } else {
            Assertions.assertEquals(String.class, weatherDTO.getSys().getCountry().getClass());
        }
    }

    @Test
    public void testSysSunriseType() {
        if (weatherDTO.getSys().getSunrise() == null) {
            Assertions.assertNull(weatherDTO.getSys().getSunrise());
        } else {
            Assertions.assertEquals(Integer.class, weatherDTO.getSys().getSunrise().getClass());
        }
    }

    @Test
    public void testSysSunsetType() {
        if (weatherDTO.getSys().getSunset() == null) {
            Assertions.assertNull(weatherDTO.getSys().getSunset());
        } else {
            Assertions.assertEquals(Integer.class, weatherDTO.getSys().getSunset().getClass());
        }
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
