package com.padcassignment.mmhealthcare.activities

import android.os.Bundle

import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.padcassignment.mmhealthcare.R
import com.padcassignment.mmhealthcare.activities.BaseActivity
import com.padcassignment.mmhealthcare.adapters.HealthCareAdapter
import com.padcassignment.mmhealthcare.datas.models.HealthCareVO
import com.padcassignment.mmhealthcare.delegates.HealthCareDelegate
import com.padcassignment.mmhealthcare.events.ErrorEvent
import com.padcassignment.mmhealthcare.events.SuccessEvent
import com.padcmyanmar.myapplication.data.models.HealthCareModel
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity(), HealthCareDelegate {

    private var healthCareAdapter: HealthCareAdapter? = null

    override fun onTapNews(news: HealthCareVO?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_healthcare.layoutManager=LinearLayoutManager(applicationContext)
        healthCareAdapter = HealthCareAdapter(applicationContext,this)
        rv_healthcare.adapter=healthCareAdapter

        HealthCareModel.getInstance().loadHealthCare()
        //swipeRefreshLayout.isRefreshing = true

        //swipeRefreshLayout.setOnRefreshListener {
       //     HealthCareModel.getInstance().loadNews()
       // }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSuccessGetHealthCare(newsLoadedEvent: SuccessEvent.NewsLoadedEvent){
        healthCareAdapter!!.appendNewData(newsLoadedEvent.loadedNews as MutableList<HealthCareVO>)
       // swipeRefreshLayout.isRefreshing = false
    }

   /* @Subscribe(threadMode = ThreadMode.MAIN)
    fun onErrorNewsLoadedEvent(apiErrorEvent: ErrorEvent.ApiErrorEvent ) {
        swipeRefreshLayout.isRefreshing = false
        //    Snackbar.make(rvHealthCare, "ERROR : " + apiErrorEvent.getMsg(), Snackbar.LENGTH_LONG)
        //            .setAction("Action", null).show()
        var empty:View = vp_empty
        empty.visibility = View.VISIBLE






    }*/

}