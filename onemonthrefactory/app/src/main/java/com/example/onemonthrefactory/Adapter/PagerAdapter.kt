package com.example.onemonthrefactory.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.onemonthrefactory.Fragment.ContactFragment
import com.example.onemonthrefactory.Fragment.SettingFragment

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                ContactFragment()
            }
            else -> {
                return SettingFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "CONTACT"
            1 -> "CALENDAR"
            2 -> "INDEX"
            else -> {
                return "SETTINGS"
            }

        }
    }



}