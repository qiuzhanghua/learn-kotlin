package com.github.qiuzhanghua.naut

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.github.qiuzhanghua.naut")
                .mainClass(Application.javaClass)
                .start()
    }
}

// Don't click run directly
// https://docs.micronaut.io/latest/guide/index.html#kaptintellij