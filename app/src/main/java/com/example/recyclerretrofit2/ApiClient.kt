package com.example.recyclerretrofit2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    // Membuat URL
    private final val URL = "https://jsonplaceholder.typicode.com/"

    // Untuk membuat object Retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    // Membuat service yang nantinya akan dibuat
    // untuk menembak API pada MainActivity
    public fun apiCall() : ApiService {
        return retrofit.create(ApiService::class.java)
    }
}