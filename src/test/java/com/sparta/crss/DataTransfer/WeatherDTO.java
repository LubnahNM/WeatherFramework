package com.sparta.crss.DataTransfer;

import org.json.simple.JSONObject;

public class WeatherDTO implements DTO{
    JSONObject FullJSONFile;
    JSONObject coord;
    JSONObject weather;
    JSONObject main;
    JSONObject wind;
    JSONObject clouds;
    JSONObject rain;
    JSONObject snow;
    JSONObject sys;


    @Override
    public void setJSONFile(JSONObject obj) {
        FullJSONFile = obj;
        coord = (JSONObject) FullJSONFile.get("coord");
        weather = (JSONObject) FullJSONFile.get("weather");
        main = (JSONObject) FullJSONFile.get("main");
        wind = (JSONObject) FullJSONFile.get("wind");
        clouds = (JSONObject) FullJSONFile.get("clouds");
        rain = (JSONObject) FullJSONFile.get("rain");
        snow = (JSONObject) FullJSONFile.get("snow");
        sys = (JSONObject) FullJSONFile.get("sys");

    }

    public String getBase(){ return (String) FullJSONFile.get("base"); }

    public Long getID(){ return (Long) FullJSONFile.get("id"); }

    public Long getTimeZone() { return (Long) FullJSONFile.get("timezone");}

    public String getName() { return (String) FullJSONFile.get("name");}

    public Integer getVisibility() { return (Integer) FullJSONFile.get("visibility");}

    public Integer getCod(){ return (Integer) FullJSONFile.get("200");}

    public Long getDt(){ return (Long) FullJSONFile.get("dt");}



    public JSONObject getCoord() { return coord; }

    public Double getLon() { return (Double) coord.get("lon");}
    public Double getLat() { return (Double) coord.get("lat");}


    public JSONObject getWeather() { return weather; }

    public Integer getWeatherId() { return (Integer)weather.get("id");}
    public String getWeatherMain() { return (String) weather.get("main");}
    public String getDescription() { return (String) weather.get("description");}
    public String getIcon() { return (String) weather.get("icon");}


    public JSONObject getMain() { return main; }

    public Double getTemp(){ return (Double) main.get("temp") ;}
    public Double getFeels_Like(){ return (Double) main.get("feels_like") ;}
    public Double getTemp_Min(){ return (Double) main.get("temp_min") ;}
    public Double getTemp_Max(){ return (Double) main.get("temp_max") ;}
    public Double getPressure(){ return (Double) main.get("pressure") ;}
    public Double getHumidity(){ return (Double) main.get("humidity") ;}


    public JSONObject getWind() { return wind; }

    public Integer getSpeed() { return (Integer) wind.get("speed");}
    public Integer getDeg() { return (Integer) wind.get("deg");}


    public JSONObject getClouds() { return clouds; }

    public Integer getCloudsAll() { return (Integer) clouds.get("all");}


    public JSONObject getRain() { return rain; }

    public Long getRain1h() {  return (Long) rain.get("1h");}
    public Long getRain3h() {  return (Long) rain.get("3h");}


    public JSONObject getSnow() { return snow; }

    public Long getSnow1h() {  return (Long) snow.get("1h");}
    public Long getSnow3h() {  return (Long) snow.get("3h");}


    public JSONObject getSys() { return sys; }

    public Integer getType(){return (Integer) sys.get("type");}
    public Integer getId(){return (Integer) sys.get("id");}
    public Double getMessage(){return (Double) sys.get("message");}
    public String getCountry(){return (String) sys.get("country");}
    public Long getSunrise(){return (Long) sys.get("sunrise");}
    public Long getSunset(){return (Long) sys.get("sunset");}
}
