package com.example.demo.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.demo.model.Country
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select


interface CountryMapper : BaseMapper<Country> {

//    no more base query method, use BaseMapper method
//    @Select("SELECT * FROM countries")
//    fun getAll(): List<Country>
}