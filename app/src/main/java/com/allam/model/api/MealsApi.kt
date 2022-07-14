package com.allam.model.api

import com.allam.model.Response.MealsCategoriseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MealsWebService {
    private lateinit var api: MealsApi


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)

    }

    suspend fun getMeals(): MealsCategoriseResponse {
        return api.getMeals()

    }

    interface MealsApi {
        @GET("categorise.php")
        suspend fun getMeals(): MealsCategoriseResponse

    }
}