package com.padcassignment.mmhealthcare.events

import com.padcassignment.mmhealthcare.datas.models.HealthCareVO


class SuccessEvent
{
    class HealthCareLoadedEvent(val loadedHealthCare: List<HealthCareVO>)

    class EmptyDataLoadedEvent(val errorMsg: String? ="Empty Response")
}