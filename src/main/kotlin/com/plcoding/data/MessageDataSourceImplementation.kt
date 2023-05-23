package com.plcoding.data

import com.plcoding.data.model.Message
import org.litote.kmongo.coroutine.CoroutineDatabase

class MessageDataSourceImplementation(
    private val db: CoroutineDatabase
): MessageDataSource {

    private val messages = db.getCollection<Message>()
    override suspend fun getAllMessages(): List<Message> {
        return messages.find().descendingSort(Message::timestamp).toList()
    }

    override suspend fun insertMessage(message: Message) {
        messages.insertOne(message)
    }
}