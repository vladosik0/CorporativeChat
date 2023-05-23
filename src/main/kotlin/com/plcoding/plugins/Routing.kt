package com.plcoding.plugins


import com.plcoding.room.RoomController
import com.plcoding.routes.chatSocket
import com.plcoding.routes.getAllMessages
import io.ktor.application.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing){
        chatSocket(roomController = roomController)
        getAllMessages(roomController = roomController)
    }
}
