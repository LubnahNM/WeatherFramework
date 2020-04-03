package com.sparta.crss.DataInjection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.crss.JacksonClasses.MultiWeatherDTO;
import com.sparta.crss.JacksonClasses.WeatherDTO;
import com.sparta.crss.URL.URLBuilder;

import java.io.IOException;
import java.net.URL;

public class RequestHandler {
    ObjectMapper objectMapper = new ObjectMapper();
    URLBuilder urlBuilder;
    public RequestHandler(String s){
        urlBuilder = new URLBuilder(s); // add the url call that inherit the URLBuilder
    }

    public void updateRequest(String s){
        urlBuilder = new URLBuilder(s);
    }

    public WeatherDTO createResult(){
        WeatherDTO weatherQuery = new WeatherDTO();
        try {
            weatherQuery= objectMapper.readValue(new URL(urlBuilder.getURL()), WeatherDTO.class);//where to get it and
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherQuery;
    }

    public MultiWeatherDTO createMultiResult(){
        MultiWeatherDTO weatherQuery = new MultiWeatherDTO();
        try {
            weatherQuery= objectMapper.readValue(new URL(urlBuilder.getURL()), MultiWeatherDTO.class);//where to get it and
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherQuery;
    }

    //    private void setDTO(String url){
//        boolean isFoundCityName = url.contains("weather?q=");
//        boolean isFoundCityID = url.contains("weather?id=");
//        boolean isFoundGeo = url.contains("weather?lat=");
//        boolean isFoundZip = url.contains("weather?zip=");
//
//        boolean isFoundRectangle = url.contains("box/city?bbox");
//        boolean isFoundCircle = url.contains("find?lat=");
//        boolean isFoundGroupID = url.contains("group?id=");
//
//        if (isFoundCityName|isFoundCityID|isFoundGeo|isFoundZip){
//            createResult();
//        }
//        else if (isFoundRectangle|isFoundCircle|isFoundGroupID){
//            createMultiResult();
//        }
//        else{
//            //ERROR MESSAGE
//            System.out.println("Error in RequestHandler");
//        }
//    }
}
