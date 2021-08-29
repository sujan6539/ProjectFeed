package com.sujan.code.newsfeed.controller.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sujan.code.newsfeed.R
import com.sujan.code.newsfeed.controller.fragment.HomeFragment
import com.sujan.code.newsfeed.dagger.Injector
import com.sujan.code.newsfeed.repository.AppRepository
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: AppRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.getInstance(applicationContext).getAppComponent()?.inject(this)
        setContentView(R.layout.activity_home)
        addFragment()
    }

    private fun addFragment() {
        val homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.layout_frame, homeFragment, HomeFragment::javaClass.name).commit()

    }
}