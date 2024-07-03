package com.egbas.demo_hng.controller;

import com.egbas.demo_hng.model.Visitor;
import com.egbas.demo_hng.service.WeatherService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class visitorController {
    private final WeatherService weatherService;

    @GetMapping("/hello")
    public ResponseEntity<Visitor> greeting(@RequestParam(name = "visitor_name") String visitor_name, HttpServletRequest request){
            return weatherService.greetings(visitor_name, request);
    }
}
