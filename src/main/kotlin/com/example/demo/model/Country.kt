package com.example.demo.model

import com.baomidou.mybatisplus.annotation.TableName

// model
@TableName("countries")
data class Country(val id: Int, val name: String)