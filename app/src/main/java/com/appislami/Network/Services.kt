package com.appislami.Network

import retrofit2.Call
import retrofit2.http.GET

interface Services {
    @GET("radio_ar.json")
    fun getRadoiDataFromApi():Call<RadioResponse>
}