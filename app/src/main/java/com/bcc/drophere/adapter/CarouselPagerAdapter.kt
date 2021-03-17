package com.bcc.drophere.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bcc.drophere.ui.fragment.landing.CarouselContentFragment

class CarouselPagerAdapter(fragment: Fragment, val list: List<Array<String>>, val page: Int) :
    FragmentStateAdapter(fragment) {

    companion object {
        const val PASS = "PASS_DATA"
    }

    override fun getItemCount(): Int = page

    override fun createFragment(position: Int): Fragment {
        val fragment = CarouselContentFragment()
        when (position) {
            0 ->
                fragment.arguments = Bundle().apply {
                    putStringArray(PASS, list[0])
                }
            1 ->
                fragment.arguments = Bundle().apply {
                    putStringArray(PASS, list[1])
                }
            2 ->
                fragment.arguments = Bundle().apply {
                    putStringArray(PASS, list[1])
                }
        }
        return fragment
    }
}