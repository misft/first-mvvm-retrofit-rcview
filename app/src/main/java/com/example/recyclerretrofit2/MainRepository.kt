package com.example.recyclerretrofit2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    private var instance : ApiClient = ApiClient()

    fun getInstance(): ApiClient {
        if(instance == null) {
            instance = ApiClient()
        }
        return instance
    }

    public fun getTodos() : LiveData<List<TodosModel>> {
        var todosList : MutableLiveData<List<TodosModel>> = MutableLiveData()
        getInstance().apiCall().getTodos().enqueue(object : Callback<List<TodosModel>> {
            override fun onFailure(call: Call<List<TodosModel>>, t: Throwable) {

            }
            override fun onResponse(
                call: Call<List<TodosModel>>,
                response: Response<List<TodosModel>>
            ) {
                todosList.value = response.body()!!
            }
        })

        return todosList
    }

}
