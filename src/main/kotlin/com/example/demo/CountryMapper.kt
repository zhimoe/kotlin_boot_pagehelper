package com.example.demo

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select


@Mapper
interface CountryMapper {

    @Select("SELECT * FROM countries")
    fun getAll(): List<Country>
}