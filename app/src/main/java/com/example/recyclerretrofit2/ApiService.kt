package com.example.recyclerretrofit2

import retrofit2.Call
import retrofit2.http.GET

// URL apa saja yang akan diakses akan masuk kesini
interface ApiService{
    @GET("todos")
    fun getTodos() : Call<List<TodosModel>>
}