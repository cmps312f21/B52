package com.cmps312.myapplication.repository

import android.content.Context
import com.cmps312.myapplication.model.Stadium
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.util.*

//Todo Add the SortBy

object SortBy{
    const val SEATING_CAPACITY = "SEATING CAPACITY"
    const val STADIUM_NAME = "STADIUM NAME"
    const val CITY_NAME = "CITY NAME"
    const val ALL = "ALL"
}

object StadiumRepo {
    private var stadiums = listOf<Stadium>()

    fun getStadiums(context: Context): List<Stadium> {
        if (stadiums.isEmpty()) {
            val stadiumJsonString = context
                .assets.open("stadiums.json")
                .bufferedReader().use { it.readText() }

            //convert the stadiums json to Stadiums object
            stadiums = Json.decodeFromString(stadiumJsonString)
        }
        return stadiums
    }

    fun filterStadiumByStatus(status: String) = when (status) {
        "All" -> stadiums
        else -> stadiums.filter { it.status.contains(status) }
    }

    fun filterStadiumByName(name: String) = stadiums.filter {
        it.name.lowercase(Locale.getDefault()).contains(name.lowercase(
            Locale.getDefault()))
    }

    fun getStadium(name: String) = stadiums.find { it.name.contains(name) }

   //todo implement the sort

}