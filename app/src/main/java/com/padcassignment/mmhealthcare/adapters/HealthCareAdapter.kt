package com.padcassignment.mmhealthcare.adapters

import android.content.Context
import android.view.ViewGroup
import com.padcassignment.mmhealthcare.R
import com.padcassignment.mmhealthcare.adapters.HealthCareViewHolder
import com.padcassignment.mmhealthcare.datas.models.HealthCareVO
import com.padcassignment.mmhealthcare.delegates.HealthCareDelegate
import com.padcmyanmar.myapplication.adapters.BaseRecyclerAdapter

class HealthCareAdapter(context: Context, private val healthCareDelegate: HealthCareDelegate) : BaseRecyclerAdapter <HealthCareViewHolder, HealthCareVO>(context){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthCareViewHolder {
        val healthCareItemView = healthLayoutInflater.inflate(R.layout.viewholder_list,parent,false)
        return HealthCareViewHolder(healthCareItemView,healthCareDelegate)

    }

}