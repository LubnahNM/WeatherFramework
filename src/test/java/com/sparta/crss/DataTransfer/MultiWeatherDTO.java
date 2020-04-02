package com.sparta.crss.DataTransfer;

import org.json.simple.JSONObject;

import java.util.List;

public class MultiWeatherDTO implements DTO{
    JSONObject FullJSONFile;

    String cod;
    Double calctime;
    String message;
    Integer cnt;
    Integer count;
    JSONObject list;


    @Override
    public void setJSONFile(JSONObject obj) {
        FullJSONFile = obj;
        cod = (String) FullJSONFile.get("cod");
        calctime = (Double) FullJSONFile.get("calctime");
        message = (String) FullJSONFile.get("message");
        cnt = (Integer) FullJSONFile.get("cnt");
        count = (Integer) FullJSONFile.get("count");
        list = (JSONObject) FullJSONFile.get("list");
    }

    public String getCod() { return cod; }

    public Double getCalctime() { return calctime; }

    public String getMessage() { return message; }

    public Integer getCnt() { return cnt; }

    public Integer getCount() { return count; }

    public JSONObject getList() { return list; }

    public JSONObject getEntryAt(int i) { return (JSONObject) list.get("list[" + i + "]");}
}
