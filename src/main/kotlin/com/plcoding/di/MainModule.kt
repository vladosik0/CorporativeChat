package com.plcoding.di

import com.plcoding.data.MessageDataSource
import com.plcoding.data.MessageDataSourceImplementation
import com.plcoding.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo.createClient().coroutine.getDatabase("message_db")
    }
    single<MessageDataSource>{
        MessageDataSourceImplementation(get())
    }
    single {
        RoomController(get())
    }
}