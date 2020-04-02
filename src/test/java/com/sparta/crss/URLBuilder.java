package com.sparta.crss;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class URLBuilder {

    public URLBuilder(String query){

            Properties properties = new Properties();
            try {
                properties.load(new FileReader("src/test/resources/Url.properties"));
                String baseURL = properties.getProperty("baseURL");
                String myToken = properties.getProperty("myToken");
                urlResponse(baseURL,query, myToken);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public String urlResponse(String baseURL, String query,String myToken){
        String URL = baseURL + query + myToken;
        return URL;
    }

}
