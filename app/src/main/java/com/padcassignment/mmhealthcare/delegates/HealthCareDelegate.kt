package com.padcassignment.mmhealthcare.delegates

import com.padcassignment.mmhealthcare.datas.models.HealthCareVO


interface HealthCareDelegate
{
    fun onTapNews(news: HealthCareVO?)
}