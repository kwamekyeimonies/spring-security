package com.keycloackauthentication.keycloackauthentication.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/demo")
public class DemoController {

    @GetMapping("/greeting")
    @PreAuthorize("hasRole(client_admin)")
    public String greetings(){
        return "Welcome to tea-Code security";
    }

    @GetMapping("bye")
//    @PreAuthorize("hasRole(client_user)")
    public  String homegreetings(){
        return  "Bye,return home safely";
    }

}
