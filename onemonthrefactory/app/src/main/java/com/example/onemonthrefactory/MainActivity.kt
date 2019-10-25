package com.example.onemonthrefactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.onemonthrefactory.Fragment.CalendarFragment
import com.example.onemonthrefactory.Fragment.ContactFragment
import com.example.onemonthrefactory.Fragment.InboxFragment
import com.example.onemonthrefactory.Fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var content: FrameLayout? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        item -> when(item.itemId) {
                        R.id.contact -> {
                            val fragment = ContactFragment()
                            addFragment(fragment)
                            return@OnNavigationItemSelectedListener true
                        }

                        R.id.calendar -> {
                            val fragment = CalendarFragment()
                            addFragment(fragment)
                            return@OnNavigationItemSelectedListener true
                        }

                        R.id.inbox -> {
                            val fragment = InboxFragment()
                            addFragment(fragment)
                            return@OnNavigationItemSelectedListener true
                        }

                        R.id.setting -> {
                            val fragment = SettingFragment()
                            addFragment(fragment)
                            return@OnNavigationItemSelectedListener true
                        }

                    else -> false
                }
            }

    private fun addFragment(fragment: Fragment) {

        @Suppress("UsePropertyAccessSyntax")
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
            .commit()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = ContactFragment()
        addFragment(fragment)

    }
}
