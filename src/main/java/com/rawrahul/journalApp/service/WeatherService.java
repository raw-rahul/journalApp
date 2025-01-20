package com.rawrahul.journalApp.service;

import com.rawrahul.journalApp.api.response.WeatherResponse;
import com.rawrahul.journalApp.cache.AppCache;
import com.rawrahul.journalApp.constants.Placeholders;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


//@Component
@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apikey;
//    private static final String api = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public WeatherResponse getWeather(String city){
        String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.API_KEY, apikey).replace(Placeholders.CITY, city);

        // header -> null in the below line
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }


}
