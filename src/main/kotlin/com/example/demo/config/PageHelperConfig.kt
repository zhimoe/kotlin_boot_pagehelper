package com.example.demo.config

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.Properties

@Configuration
class PageHelperConfig {
    //  pagehelper 分页设置
    //  see https://pagehelper.github.io/docs/howtouse/#2-%E9%85%8D%E7%BD%AE%E6%8B%A6%E6%88%AA%E5%99%A8%E6%8F%92%E4%BB%B6
    @Bean
    fun pageInterceptor(): PageHelper {
        val pi = PageHelper()
        val props = Properties()
        // 必须得 否则count total>0但是不执行查询语句
        props.setProperty("offsetAsPageNum", "True")
        pi.setProperties(props)
        return pi
    }
}