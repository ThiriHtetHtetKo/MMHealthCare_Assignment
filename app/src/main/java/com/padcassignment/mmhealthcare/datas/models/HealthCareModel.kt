package com.padcmyanmar.myapplication.data.models

import com.padcassignment.mmhealthcare.datas.models.HealthCareVO
import com.padcassignment.mmhealthcare.events.SuccessEvent
import com.padcassignment.mmhealthcare.network.HealthCareDataAgent
import com.padcassignment.mmhealthcare.utils.HealthCareConstants
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class HealthCareModel
{
    companion object {
        //sigleton
        private var INSTANCE: HealthCareModel? = null
        fun getInstance(): HealthCareModel {
            if (INSTANCE == null) {
                INSTANCE = HealthCareModel()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private constructor() {
        EventBus.getDefault().register(this)
    }

    private var healthCarePage: Int = 1
    private var healthCareDate: HashMap<Int,HealthCareVO> = HashMap()

    fun loadHealthCare(){
        HealthCareDataAgent.getInstance().loadHealthCare(HealthCareConstants.ACCESS_TOKEN)
    }

    fun forceLoadHealthCare() {
        healthCarePage = 1
        healthCareDate = HashMap()
        HealthCareDataAgent.getInstance().loadHealthCare(HealthCareConstants.ACCESS_TOKEN)
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onHealthCareLoadedEvent(healthCareLoadedEvent: SuccessEvent.HealthCareLoadedEvent) {
        for (healthCare: HealthCareVO in healthCareLoadedEvent.loadedHealthCare) {
            healthCareDate[healthCare.id] = healthCare
        }

    }

}