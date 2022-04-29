package com.yildiz.depremproject.service

import com.yildiz.depremproject.model.DepremModel
import io.reactivex.Single
import retrofit2.http.GET

interface DepremAPI {

    companion object{
        const val DEPREM = "deprem/live.php?limit=100"
    }

    @GET(DEPREM)
    fun getDeprem() : Single<DepremModel>

}