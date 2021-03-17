package com.example.navigationkotlinproject.apicall

import android.text.TextUtils
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Industry {


    companion object {
        val API_BASE_URL = "https://newadminapi-staging.findanexpert.net/api/"

        private val httpClient = OkHttpClient.Builder()

        private val builder = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
        private var retrofit: Retrofit = builder.build()


         fun <S> createService(
                serviceClass: Class<S>?, authToken: String?): S {
            if (!TextUtils.isEmpty(authToken)) {


                val interceptor = authToken?.let { AuthenticationInterceptor(it) }

                if (!httpClient.interceptors().contains(interceptor)) {
                    httpClient.addInterceptor(interceptor)

                    builder.client(httpClient.build())
                    retrofit = builder.build()
                }
            }
            return retrofit.create(serviceClass)
        }

        fun <S> createServices(serviceClass: Class<S>, username: String, password: String): S {
            if (!TextUtils.isEmpty(username)
                    && !TextUtils.isEmpty(password)) {
                val authToken = Credentials.basic(username, password)
                return createService(serviceClass, authToken)
            }
            return createService(serviceClass, null)

        }

    }
}