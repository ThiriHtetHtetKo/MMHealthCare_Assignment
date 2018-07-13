package com.padcassignment.mmhealthcare.network

import com.google.gson.Gson
import com.padcassignment.mmhealthcare.events.ErrorEvent
import com.padcassignment.mmhealthcare.events.SuccessEvent
import com.padcassignment.mmhealthcare.networks.responses.GetHealthCareResponse
import com.padcassignment.mmhealthcare.utils.HealthCareConstants
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class HealthCareDataAgent {

    //skeleton structure
    companion object {
        private var INSTANCE: HealthCareDataAgent? = null
        fun getInstance(): HealthCareDataAgent {
            if (INSTANCE == null) {
                INSTANCE = HealthCareDataAgent()
            }
            val i = INSTANCE
            return i!!
        }
    }

    private val healthCareApi: HealthCareApi

    private constructor() {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl(HealthCareConstants.API_BASE)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        healthCareApi = retrofit.create(HealthCareApi::class.java)
    }
    fun loadHealthCare(accessToken: String){
        val healthCareResponseCall = healthCareApi.loadHealthCare(accessToken)
        healthCareResponseCall.enqueue(object : Callback<GetHealthCareResponse> {
            override fun onFailure(call: Call<GetHealthCareResponse>?, t: Throwable?) {
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }

            override fun onResponse(call: Call<GetHealthCareResponse>, response: Response<GetHealthCareResponse>) {
                val healthCareResponse: GetHealthCareResponse? = response.body()
                if (healthCareResponse != null
                        && healthCareResponse.getCode() == 200
                        && healthCareResponse.getList().isNotEmpty()) {
                    val healthCareLoadedEvent = SuccessEvent.HealthCareLoadedEvent( healthCareResponse.getList())
                    EventBus.getDefault().post(healthCareLoadedEvent)
                } else {
                    if(healthCareResponse != null)
                        EventBus.getDefault().post(SuccessEvent.EmptyDataLoadedEvent(healthCareResponse.getMessage()))
                    else
                        EventBus.getDefault().post(SuccessEvent.EmptyDataLoadedEvent())
                }
            }
        })
    }


}