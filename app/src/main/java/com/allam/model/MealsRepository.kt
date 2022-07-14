package com.allam.model

import com.allam.model.Response.MealResponse
import com.allam.model.Response.MealsCategoriseResponse
import com.allam.model.api.MealsWebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    private var cachedMeals = arrayListOf<MealResponse>()

    suspend fun getMeals(): MealsCategoriseResponse {
        val response = webService.getMeals()
        cachedMeals = response.categorise as ArrayList<MealResponse>
        return response
    }

    fun getMeal(id: String): MealResponse?{
        return cachedMeals.firstOrNull() {
            it.id == id
        }

    }

    companion object{
        @Volatile
        private var instance:MealsRepository? = null
        fun getInstance() = instance?: synchronized(this){
            instance ?: MealsRepository().also { instance = it }

        }
    }

}