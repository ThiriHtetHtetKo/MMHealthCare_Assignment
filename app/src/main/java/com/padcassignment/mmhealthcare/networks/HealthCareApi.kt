package com.padcassignment.mmhealthcare.network

import com.padcassignment.mmhealthcare.networks.responses.GetHealthCareResponse
import com.padcassignment.mmhealthcare.utils.HealthCareConstants
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NewsApi
{
    @FormUrlEncoded
    @POST(HealthCareConstants.GET_HEALTHCARE)
    fun loadNews(
            @Field("access_token") accessToken: String) : Call<GetHealthCareResponse>
}