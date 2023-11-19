package org.sopt.cds29cm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import org.sopt.cds29cm.R
import org.sopt.cds29cm.databinding.ActivityMainBinding
import org.sopt.cds29cm.presentation.category.CategoryFragment
import org.sopt.cds29cm.presentation.home.HomeFragment
import org.sopt.cds29cm.presentation.like.LikeFragment
import org.sopt.cds29cm.presentation.my.MyFragment
import org.sopt.cds29cm.presentation.search.SearchFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickBottomNavigation()
    }
    private fun clickBottomNavigation(){
        binding.bnvHome.setOnItemSelectedListener {
            when (it.itemId){
                R.id.menu_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.menu_category -> {
                    replaceFragment(CategoryFragment())
                    true
                }
                R.id.menu_search -> {
                    replaceFragment(SearchFragment())
                    true
                }
                R.id.menu_like -> {
                    replaceFragment(LikeFragment())
                    true
                }
                R.id.menu_my -> {
                    replaceFragment(MyFragment())
                    true
                }
                else -> false
            }
        }
    }
    private fun replaceFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_main, fragment)
            .commit()
    }
}