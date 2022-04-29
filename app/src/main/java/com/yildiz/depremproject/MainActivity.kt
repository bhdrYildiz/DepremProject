package com.yildiz.depremproject

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.yildiz.depremproject.adapter.DepremAdapter
import com.yildiz.depremproject.model.DepremModel
import com.yildiz.depremproject.service.DepremAPIService
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var depremApiService = DepremAPIService()
    private var depremnameList: ArrayList<String?> = arrayListOf()
    private val depremAdapter = DepremAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        depremApiService.getDeprem()
            .subscribeOn(Schedulers.newThread())
            .subscribeWith(object : DisposableSingleObserver<DepremModel>() {
                @RequiresApi(Build.VERSION_CODES.O)
                override fun onSuccess(depremler: DepremModel) {
                    runOnUiThread {
                        depremAdapter.setDepremData(depremler)
                        depremler.forEach {
                            it.let {
                                depremnameList.add(it.title)
                            }
                        }
                    }
                }
                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

            })

        recyclerview_layout.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerview_layout.adapter = depremAdapter
    }
}