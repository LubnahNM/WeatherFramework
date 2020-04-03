package com.sparta.crss.URL;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class URLBuilder {
    private String URL;
    private String baseURL = "http://api.openweathermap.org/data/2.5/";

    public URLBuilder(String query) {

        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/token.properties"));
            String myToken = properties.getProperty("myToken");
            urlResponse(baseURL, query,  myToken);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void urlResponse(String baseURL, String query, String myToken) {
        String URL = baseURL + query + "&appid=" + myToken;
        setURL(URL);
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }
}
