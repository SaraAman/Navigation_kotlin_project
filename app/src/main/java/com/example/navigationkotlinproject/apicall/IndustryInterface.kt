package com.example.navigationkotlinproject.apicall

import android.text.TextUtils
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IndustryInterface {
    @GET("Industry")
    fun getAllIndustry(): Call<IndustryDataModel>


}