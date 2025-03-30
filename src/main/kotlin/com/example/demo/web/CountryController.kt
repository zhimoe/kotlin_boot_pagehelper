package com.example.demo.web

import com.example.demo.model.Country
import com.example.demo.mapper.CountryMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CountryController {

    @Autowired
    private var countryMapper: CountryMapper?  = null

    @GetMapping("/all")
    fun getAll(): List<Country>{
        val c = countryMapper?.selectList(null)
        if (c.isNullOrEmpty()){
            return ArrayList()
        }
        return c
    }
}