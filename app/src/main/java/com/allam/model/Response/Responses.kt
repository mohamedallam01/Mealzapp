package com.allam.model.Response

import com.google.gson.annotations.SerializedName

data class MealsCategoriseResponse( val categorise: List<MealResponse>)

data class MealResponse(
    @SerializedName("idCategory")  val  id:String,
    @SerializedName("strCategory")  val  name:String,
    @SerializedName("strCategoryThumb")  val  imageurl:String,
    @SerializedName("strCategoryDescription")  val  description:String)