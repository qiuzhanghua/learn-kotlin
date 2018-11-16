package com.github.qiuzhanghua.naut

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.views.View

@Controller("/views")
internal class ViewsController {

    @View("home")
    @Get("/")
    fun index(): HttpResponse<Map<String, Any>> {
        val map = mutableMapOf<String, Any>("loggedIn" to true, "username" to "Daniel")
        return HttpResponse.ok<Map<String, Any>>(map)
    }

}