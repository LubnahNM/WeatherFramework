package com.sparta.crss.JacksonClasses;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message",
        "cod",
        "count",
        "list",
        "calctime",
        "cnt"
})
public class MultiWeatherDTO {



    @JsonProperty("message")
    private String message;
    @JsonProperty("cod")
    private String cod;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("cnt")
    private Integer cnt;
    @JsonProperty("calctime")
    private Double calctime;

    @JsonProperty("cnt")
    public Integer getCnt() { return cnt; }

    @JsonProperty("cnt")
    public void setCnt(Integer cnt) { this.cnt = cnt; }

    @JsonProperty("calctime")
    public Double getCalctime() { return calctime; }

    @JsonProperty("calctime")
    public void setCalctime(Double calctime) { this.calctime = calctime; }

    @JsonProperty("list")
    private java.util.List<WeatherDTO> list = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("cod")
    public String getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(String cod) {
        this.cod = cod;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("list")
    public java.util.List<WeatherDTO> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(java.util.List<WeatherDTO> list) {
        this.list = list;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}