package com.technzone.car_auto_browser.ui.main.activity.carauto

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.technzone.car_auto_browser.R
import com.technzone.car_auto_browser.data.common.Constants
import com.technzone.car_auto_browser.data.enums.CarAutoPageEnum
import com.technzone.car_auto_browser.data.models.CarAutoPageItem
import com.technzone.car_auto_browser.ui.base.activity.BaseBindingCarActivity

class MainCarActivity : BaseBindingCarActivity() {

    lateinit var carAutoMainAdapter: CarAutoMainAdapter
    var vpOnBoarding: ViewPager2? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_main, hasToolbar = false)
        vpOnBoarding = findViewById(R.id.vpOnBoarding) as ViewPager2
        setupNavigation()
        setUpPager()
    }
    private fun setupNavigation() {
//        val navController = findNavController( findViewById(R.id.relRoot) )
////        navController.saveState()
        val bnvMain = findViewById(R.id.bnv_main) as BottomNavigationView
        bnvMain?.let {
            it.setOnNavigationItemReselectedListener {
                // Do Nothing To Disable ReLunch fragment when reClick on nav icon
            }
            it.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_home -> {
                        vpOnBoarding?.setCurrentItem(0,true)
                    }
                    R.id.nav_search -> {
                        vpOnBoarding?.setCurrentItem(1,true)
                    }
                    else -> {
                        vpOnBoarding?.setCurrentItem(2,true)
                    }
                }
                return@setOnNavigationItemSelectedListener true
            }
        }

    }
    private fun setUpPager() {
        val items = arrayOf(
            CarAutoPageItem(
                url = Constants.YOUTUBE,
                pageEnum = CarAutoPageEnum.HOME
            ),
            CarAutoPageItem(
                url = Constants.GOOGLE,
                pageEnum = CarAutoPageEnum.EXPLORE
            )
        )
        carAutoMainAdapter =
            CarAutoMainAdapter(this).apply { submitItems(items.toList()) }
        vpOnBoarding?.isUserInputEnabled = false
        vpOnBoarding?.adapter = carAutoMainAdapter
        vpOnBoarding?.registerOnPageChangeCallback(pagerCallback)
    }

    private var pagerCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
        }
    }

    companion object {
        fun start(
            context: Context?
        ) {
            val intent = Intent(context, MainCarActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
        }
    }

}