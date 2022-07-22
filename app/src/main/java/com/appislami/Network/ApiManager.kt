package com.appislami.Network

import com.appislami.Adpter.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
    companion object{
        var retrofit:Retrofit?=null
        fun getRetrofitnstance():Retrofit{
            if (retrofit==null){
                retrofit=Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build()


            }
return retrofit!!

        }
        fun getApi():Services{

            return getRetrofitnstance().create(Services::class.java)
        }

    }

}