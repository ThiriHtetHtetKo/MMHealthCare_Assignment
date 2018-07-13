package com.padcassignment.mmhealthcare.adapters

import android.view.View
import com.bumptech.glide.Glide
import com.padcassignment.mmhealthcare.datas.models.HealthCareVO
import com.padcassignment.mmhealthcare.delegates.HealthCareDelegate
import com.padcmyanmar.myapplication.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.viewholder_list.view.*

class HealthCareViewHolder(itemView: View , private val healthDelegate : HealthCareDelegate): BaseViewHolder<HealthCareVO>(itemView)
{
    override fun setData(data: HealthCareVO) {
        healthData = data

        itemView.tv_title!!.text = data.title

        itemView.tv_authorname!!.text=data.author!!.authorName

            Glide.with(itemView.context)
                    .load(data.image)
                    .into(itemView.iv_image)

        itemView.tv_infotype!!.text = data.infoType

    }

    override fun onClick(p0: View?) {
        healthDelegate.onTapHealthCare(healthData)
    }

}
