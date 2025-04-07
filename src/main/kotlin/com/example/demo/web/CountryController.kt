package com.example.demo.web

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.example.demo.model.Country
import com.example.demo.mapper.CountryMapper
import com.github.pagehelper.Page
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
class CountryController {
    val log: Logger = LoggerFactory.getLogger(CountryController::class.java)

    @Autowired
    private var countryMapper: CountryMapper? = null

    @GetMapping("/all")
    fun getAll(): List<Country> {
        val c = countryMapper?.selectList(null)
        if (c.isNullOrEmpty()) {
            return ArrayList()
        }
        return c
    }

    @GetMapping("/page")
    fun getPage(): PageInfo<Country> {
        PageHelper.startPage<Country>(0, 2)
        // 下面这个无效 can not find lambda cache for this property [xx$lambda$0] of entity [Country]
        // val query = LambdaQueryWrapper<Country>().eq(Country::id, "1")
        val queryWrapper = KtQueryWrapper(Country::class.java)
        queryWrapper.eq(Country::id, "1")
        val page: List<Country>? = countryMapper?.selectList(queryWrapper)
        log.info("page: {}", page)
        val pageInfo: PageInfo<Country> = PageInfo(page)
        return pageInfo
//        > curl localhost:8080/page
//{"total":1,"list":[],"pageNum":0,"pageSize":2,"size":0,"startRow":0,"endRow":0,"pages":1,"prePage":0,"nextPage":1,"isFirstPage":false,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
    }
}