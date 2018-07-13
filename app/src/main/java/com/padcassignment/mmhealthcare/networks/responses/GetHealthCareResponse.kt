package com.padcassignment.mmhealthcare.networks.responses

import com.google.gson.annotations.SerializedName
import com.padcassignment.mmhealthcare.datas.models.HealthCareVO

class GetHealthCareResponse
{
    @SerializedName("code")
    private val code: Int = 0

    @SerializedName("message")
    private val message: String? =null

    @SerializedName("healthcare-info")
    private var healthCareList: List<HealthCareVO>? = null

    fun getCode() : Int {
        return code
    }

    fun getMessage() : String? {
        return message
    }

    fun getList(): List<HealthCareVO>
    {
        if(healthCareList == null)
        {
            healthCareList = ArrayList<HealthCareVO>()
        }
        val newsListVal = healthCareList
        return newsListVal!!
    }
}