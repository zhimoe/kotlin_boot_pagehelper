package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BootService {

    @Autowired
    private var countryMapper: CountryMapper?  = null

    @GetMapping("/all")
    fun getAll(): List<Country>{
        val c = countryMapper?.getAll()
        if (c.isNullOrEmpty()){
            return ArrayList()
        }
        return c
    }
}