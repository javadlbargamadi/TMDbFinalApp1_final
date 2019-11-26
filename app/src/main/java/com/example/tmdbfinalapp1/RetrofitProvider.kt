package com.example.tmdbfinalapp1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitProvider {

    fun provideRetrofit(): RetrofitInterface {
        return Retrofit
            .Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitInterface::class.java)
    }
}
