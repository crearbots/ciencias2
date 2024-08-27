package com.example.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class BlockchainRest {
    @GetMapping("/api/blockchain/view")
    public String getBlockchain() {
        return new String("hola");
    }
    
}
