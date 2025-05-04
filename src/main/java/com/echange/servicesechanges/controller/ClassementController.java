package com.echange.servicesechanges.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echange.servicesechanges.auth.JwtUtils;

@RestController
@RequestMapping("/api/classement")
@CrossOrigin
public class ClassementController {
    private JwtUtils jwtUtils;

    public ClassementController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }
}
