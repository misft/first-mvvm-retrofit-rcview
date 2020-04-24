package com.example.recyclerretrofit2

import retrofit2.Call
import retrofit2.http.GET

interface ApiService{
    @GET("todos")
    fun getTodos() : Call<List<TodosModel>>
}