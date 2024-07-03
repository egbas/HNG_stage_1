package com.egbas.demo_hng.controller;

import com.egbas.demo_hng.service.GreetingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class greetingController {
    @Autowired
    private GreetingService greetingService;

    @GetMapping("/api/hello")
    public Map<String, String> getGreeting(@RequestParam(name = "visitor_name") String visitorName, HttpServletRequest request) {
        String clientIp = greetingService.getClientIp(request);
        String location = greetingService.getLocation(clientIp);
        String temperature = greetingService.getTemperature(location);
        String greeting = greetingService.getGreeting(visitorName, location, temperature);

        Map<String, String> response = new HashMap<>();
        response.put("client_ip", clientIp);
        response.put("location", location);
        response.put("greeting", greeting);

        return response;
    }
    @GetMapping("api/ip")
    public String getIP(HttpServletRequest request){
        return  greetingService.getClientIp(request);
    }
}
