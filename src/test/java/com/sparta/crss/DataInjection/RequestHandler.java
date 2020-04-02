package com.sparta.crss.DataInjection;

import com.sparta.crss.DataTransfer.DTO;
import com.sparta.crss.DataTransfer.MultiWeatherDTO;
import com.sparta.crss.DataTransfer.WeatherDTO;
import com.sparta.crss.URL.URLBuilder;
import com.sparta.crss.URL.URLBuilderInterface;

public class RequestHandler {
    public void checkURL(String s){
        URLBuilder urlBuilder = new URLBuilder(s);// add the url call that inherit the URLBuilder
        setDTO(urlBuilder.getURL());
    }
    private void setDTO(String url){
        boolean isFoundCityName = url.contains("weather?q=");
        boolean isFoundCityID = url.contains("weather?id=");
        boolean isFoundGeo = url.contains("weather?lat=");
        boolean isFoundZip = url.contains("weather?zip=");

        boolean isFoundRectangle = url.contains("box/city?bbox");
        boolean isFoundCircle = url.contains("find?lat=");
        boolean isFoundGroupID = url.contains("group?id=");

        if (isFoundCityName|isFoundCityID|isFoundGeo|isFoundZip){
            createResult();
        }
        else if (isFoundRectangle|isFoundCircle|isFoundGroupID){
            createMultiResult();
        }
        else{
            //ERROR MESSAGE
            System.out.println("Error in RequestHandler");
        }
    }

    private String URL;
    URLBuilder urlBuilder;
    public void sendRequest(String s){
        urlBuilder = new URLBuilder(s);
        URL = urlBuilder.getURL();
    }


    private WeatherDTO createResult(){
        WeatherDTO weatherDTO = new WeatherDTO();
        return weatherDTO;
    }
    private MultiWeatherDTO createMultiResult(){
        MultiWeatherDTO multipleWeatherDTO = new MultiWeatherDTO(); //add multipleWeather class
        return multipleWeatherDTO;
    }

}
