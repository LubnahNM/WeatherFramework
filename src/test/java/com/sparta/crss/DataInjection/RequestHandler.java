package com.sparta.crss.DataInjection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.crss.DataTransfer.DTO;
import com.sparta.crss.DataTransfer.MultiWeatherDTO;
import com.sparta.crss.DataTransfer.WeatherDTO;
import com.sparta.crss.JacksonClasses.MultiWeatherDTOJackson;
import com.sparta.crss.JacksonClasses.WeatherDTOJackson;
import com.sparta.crss.URL.URLBuilder;
import com.sparta.crss.URL.URLBuilderInterface;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.net.URL;

public class RequestHandler {
    ObjectMapper objectMapper = new ObjectMapper();
    URLBuilder urlBuilder;
    public RequestHandler(String s){
        urlBuilder = new URLBuilder(s); // add the url call that inherit the URLBuilder
        //setDTO(urlBuilder.getURL());
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


    public WeatherDTOJackson createResult(){
        WeatherDTOJackson weatherQuery = new WeatherDTOJackson();
        try {
            weatherQuery= objectMapper.readValue(new URL(urlBuilder.getURL()),WeatherDTOJackson.class);//where to get it and
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherQuery;
    }
    public MultiWeatherDTOJackson createMultiResult(){
        MultiWeatherDTOJackson weatherQuery = new MultiWeatherDTOJackson();
        try {
            weatherQuery= objectMapper.readValue(new URL(urlBuilder.getURL()),MultiWeatherDTOJackson.class);//where to get it and
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherQuery;
    }
}
