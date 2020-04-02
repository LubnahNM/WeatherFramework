package com.sparta.crss.DataInjection;

import com.sparta.crss.DataTransfer.DTO;
import com.sparta.crss.URL.BuildURL;
import com.sparta.crss.URL.URLBuilder;

public class RequestHandler {
    public void checkURL(){
        URLBuilder urlBuilder = new BuildURL();// add the url call that inherit the URLBuilder
        String url = urlBuilder.getURL("London");
        setDTO(url);
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
        if (isFoundRectangle|isFoundCircle|isFoundGroupID){
            createMultiResult();
        }
        else{
            //ERROR MESSAGE
            System.out.println("Error Message");
        }
    }
    private DTO createMultiResult(){
        DTO multipleWeatherDTO = null; //add multipleWeather class

        return multipleWeatherDTO;
    }
    private DTO createResult(){
        DTO weatherDTO = null;

        return weatherDTO;
    }

}
