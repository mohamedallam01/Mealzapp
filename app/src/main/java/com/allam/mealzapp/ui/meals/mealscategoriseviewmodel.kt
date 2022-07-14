package com.allam.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.allam.model.MealsRepository
import com.allam.model.Response.MealResponse
import kotlinx.coroutines.*

class MealsCategoriseViewModel(private val repository: MealsRepository = MealsRepository.getInstance()):
    ViewModel() {


    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value = meals
        }
        

    }

    val mealsState: MutableState<List<MealResponse>> = mutableStateOf (emptyList<MealResponse>())



    private suspend fun getMeals(): List<MealResponse> {
             return repository.getMeals().categorise
    }
}



