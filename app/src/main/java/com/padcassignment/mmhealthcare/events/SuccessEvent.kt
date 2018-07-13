package com.padcassignment.mmhealthcare.events

import com.padcassignment.mmhealthcare.datas.models.HealthCareVO


class SuccessEvent
{
    class NewsLoadedEvent(val loadedNews: List<HealthCareVO>)

    class EmptyDataLoadedEvent(val errorMsg: String? ="Empty Body Response")
}