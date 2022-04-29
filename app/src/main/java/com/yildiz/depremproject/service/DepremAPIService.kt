package com.yildiz.depremproject.service

import com.yildiz.depremproject.model.DepremModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DepremAPIService {
    private val BASE_URL = "https://api.orhanaydogdu.com.tr/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(DepremAPI::class.java)

    fun getDeprem() : Single<DepremModel>{
        return api.getDeprem()
    }

}