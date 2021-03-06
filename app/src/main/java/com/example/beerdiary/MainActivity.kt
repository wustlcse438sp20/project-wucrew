package com.example.beerdiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.beerdiary.fragments.AddItemFragment
import com.example.beerdiary.fragments.CollectionFragment
import com.example.beerdiary.fragments.ExploreFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)
        viewpager_main.setCurrentItem(1)    //sets default tab to the center tab 
    }
}

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount() : Int {
        return 3
    }

    override fun getItem(position: Int) : Fragment {
        return when (position) {
            0 -> { CollectionFragment() }
            1 -> { ExploreFragment() }
            else -> AddItemFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Collection"
            1 -> "Explore"
            else -> "Add Item"
        }
    }

}