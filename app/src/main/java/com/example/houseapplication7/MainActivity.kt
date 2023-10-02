package com.example.houseapplication7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.houseapplication7.databinding.ActivityMainBinding
import com.example.houseapplication7.presentation.ui.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        val toolbar = binding.toolbar
        viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = CAMERA_TITLE
                1 -> tab.text = DOOR_TITLE
                2 -> tab.text = FAVOURITES_TITLE
            }
        }.attach()

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbarTitle.text = TOOLBAR_TITLE
    }
    
    companion object {
        const val CAMERA_TITLE = "Камеры"
        const val DOOR_TITLE = "Двери"
        const val FAVOURITES_TITLE = "Избранные"
        const val TOOLBAR_TITLE = "Мой дом"
    }
}