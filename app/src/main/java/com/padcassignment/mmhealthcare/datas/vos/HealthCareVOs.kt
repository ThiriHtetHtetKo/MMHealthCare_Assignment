package com.padcassignment.mmhealthcare.datas.models

import com.google.gson.annotations.SerializedName
import com.padcassignment.mmhealthcare.datas.vos.AuthorsVO

class HealthCareVO(@SerializedName("id") var id:Int = 0 ,
                       @SerializedName("title") var title: String="",
                       @SerializedName("image") var image: String="",
                       @SerializedName("author") var author: AuthorsVO?= null,
                       @SerializedName("short-description") var shortDescription: String ="",
                       @SerializedName("published-date") var publishedDate: String="",
                       @SerializedName("complete-url") var completeUrl: String="",
                       @SerializedName("info-type") var infoType: String="")
{
}