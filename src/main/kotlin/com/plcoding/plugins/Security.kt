package com.plcoding.plugins

import com.plcoding.sessions.ChatSession
import io.ktor.sessions.*
import io.ktor.application.*
import io.ktor.util.*

fun Application.configureSecurity() {
    install(Sessions) {
        cookie<ChatSession>("SESSION")
    }

    intercept(ApplicationCallPipeline.Features){
        if(call.sessions.get<ChatSession>() == null){
            val username = call.parameters["username"] ?: "Гість"
            call.sessions.set(ChatSession(username, generateNonce()))
        }
    }

}
