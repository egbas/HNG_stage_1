package com.egbas.demo_hng.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {
    private String client_ip;
    private String location;
    private String greeting;
}
