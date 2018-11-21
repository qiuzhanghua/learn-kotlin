package com.github.qiuzhanghua.learn

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.http.ContentType
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.jackson.jackson
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.sessions.*
import java.text.DateFormat

fun main(args: Array<String>) {
    val server = embeddedServer(Netty, port = 8080) {
        install(Sessions) {
            cookie<MySession>("MY_SESSION") {
                cookie.extensions["SameSite"] = "lax"
            }
        }

        install(Compression) {
            gzip {
                priority = 1.0
            }
            deflate {
                priority = 10.0
                minimumSize(1024) // condition
            }
        }

        install(ContentNegotiation) {
            jackson {
                // Configure Jackson's ObjectMapper here
                enable(SerializationFeature.INDENT_OUTPUT)
                dateFormat = DateFormat.getDateInstance()
            }
        }

        routing {
            static("/static") {
                resources("static")
            }
            get("/") {
                call.respondText("Hello World!", ContentType.Text.Plain)
            }
            get("/demo") {
                call.respondText("HELLO WORLD!")
            }
            get("json") {
                call.respond(object {val a = 1})
 //               call.respond("ABC")
            }
            get("/session/increment") {
                val session = call.sessions.get<MySession>() ?: MySession()
                call.sessions.set(session.copy(count = session.count + 1))
                call.respondText("Counter is ${session.count}. Refresh to increment.")
            }

        }
    }
    server.start(wait = true)
}

data class MySession(val count: Int = 0)
