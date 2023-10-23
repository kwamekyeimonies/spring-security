package com.keycloackauthentication.keycloackauthentication.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/demo")
public class DemoController {

    @GetMapping("/greeting")
    public ResponseEntity<String> greetings(){
        return ResponseEntity.ok("Welcome to tea-Code security");
    }


}
