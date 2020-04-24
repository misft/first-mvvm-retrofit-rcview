package com.example.recyclerretrofit2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private final val URL = "https://jsonplaceholder.typicode.com/"

    public fun getRetrofitInstance() : Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    public fun apiCall() : ApiService {
        return getRetrofitInstance().create(ApiService::class.java)
    }
}