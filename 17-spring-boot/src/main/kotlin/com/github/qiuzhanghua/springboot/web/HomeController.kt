package com.github.qiuzhanghua.springboot.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/")
class HomeController {

    @GetMapping("")
    @ResponseBody
    fun index(): String {
        return "Hello Spring Boot from Kotlin!"
    }
}