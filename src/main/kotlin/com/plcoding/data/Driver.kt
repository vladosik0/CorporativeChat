package com.plcoding.data

data class Driver(
    val individualNumber: String,
    val liters: Int,
    val isOverspending: Boolean,
    val hryvnasPerLiter: Int = 43
    )

val drivers = listOf(
    Driver("1234567",5,false),
    Driver("1234568",10,true),
    Driver("1234569",10,false)
)
