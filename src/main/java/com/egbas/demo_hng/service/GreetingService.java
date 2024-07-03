package com.egbas.demo_hng.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class GreetingService {
    private final RestTemplate restTemplate;

    @Autowired
    public GreetingService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getClientIp(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        return ipAddress;
    }

//    public String getLocation(String clientIp) {
//        String url = "http://ip-api.com/json/"+clientIp;
//        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
//        return response != null ? (String) response.get("country") : "Unknown";
//    }
public static String getLocation(String clientIp) {
    String url = "http://ip-api.com/json/" + clientIp;
    RestTemplate restTemplate = new RestTemplate();

    // Make the GET request and get the response
    ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

    // Check if the request was successful
    if (response.getStatusCode().is2xxSuccessful()) {
        Map<String, Object> responseBody = response.getBody();

        // Extract location details from the response
        String city = (String) responseBody.get("city");

        return city;
    } else {
        return "Failed to fetch location data: HTTP response code " + response.getStatusCode();
    }
}

    @Value("${openweathermap.api.key}")
    private String openweathermapApiKey;

    public String getTemperature(String location) {
       // String apiKey = "66ecb9766ba871a2912fc51abb7ddf32";
        //String location = "Ibadan";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + openweathermapApiKey + "&units=metric";
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        Map<String, Object> main = (Map<String, Object>) response.get("main");
        return main != null ? main.get("temp") + " degrees Celsius" : "Unknown";
    }

    public String getGreeting(String visitorName, String location, String temperature) {
        return "Hello, " + visitorName + "!, the temperature is " + temperature + " in " + location;
    }
}
