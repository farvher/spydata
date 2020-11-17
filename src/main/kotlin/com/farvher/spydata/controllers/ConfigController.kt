package com.farvher.spydata.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ConfigController {

    @GetMapping("/config")
    fun getConfig(): String{

        return "";
    }
}