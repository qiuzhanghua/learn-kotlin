package com.github.qiuzhanghua.naut

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces


@Controller("/hello")
public class HelloController {
    @Get
    fun index(): HttpResponse<String> {
        return HttpResponse.ok<String>().body("{\"msg\":\"This is JSON\"}")
    }

    @Produces(MediaType.TEXT_HTML)
    @Get("/html")
    fun html(): String {
        return "<html><title>hello</title><body><h1>HTML</h1></body></html>"
    }

}