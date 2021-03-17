package com.example.navigationkotlinproject.apicall

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor(authToken: String) : Interceptor {

    private var auth: String = ""

    init {
        auth = authToken.capitalize()

    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val builder = original.newBuilder()
                .header("Authorization", auth)

        val request = builder.build()
        return chain.proceed(request)
    }
}