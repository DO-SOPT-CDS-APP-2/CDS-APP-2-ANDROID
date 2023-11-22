package org.sopt.cds29cm.presentation.hatDetail

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import org.sopt.cds29cm.R
import org.sopt.cds29cm.databinding.ActivityHatDetailBinding
import org.sopt.cds29cm.util.base.BindingActivity
import org.sopt.cds29cm.util.extension.computeDistanceToView
import org.sopt.cds29cm.util.extension.smoothScrollToView

class HatDetailActivity : BindingActivity<ActivityHatDetailBinding>(R.layout.activity_hat_detail) {

    private val tabTextList = listOf("상품정보", "사이즈", "추천", "리뷰", "문의")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initTabLayoutSelectedListener()
        initOnScrollChangeListener()
    }

    private fun initTabLayoutSelectedListener() {
        binding.tabHatDetail.setDetailTabNames()
        binding.tabHatDetail.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> binding.svHatDetail.smoothScrollToView(binding.layoutInfo)
                    1 -> binding.svHatDetail.smoothScrollToView(binding.layoutSize)
                    2 -> binding.svHatDetail.smoothScrollToView(binding.layoutRecommend)
                    3 -> binding.svHatDetail.smoothScrollToView(binding.layoutReview)
                    4 -> binding.svHatDetail.smoothScrollToView(binding.layoutAsk)
                }
                binding.appbarHatDetail.setExpanded(false)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) = Unit
            override fun onTabReselected(tab: TabLayout.Tab?) = Unit
        })
    }

    private fun TabLayout.setDetailTabNames() {
        for (tabName in tabTextList) {
            val tab = this.newTab()
            tab.text = tabName
            this.addTab(tab)
        }
    }

    private fun initOnScrollChangeListener() {
        val distances = listOf(
            binding.layoutSize,
            binding.layoutRecommend,
            binding.layoutReview,
            binding.layoutAsk
        ).map { binding.svHatDetail.computeDistanceToView(it) }

        binding.svHatDetail.setOnScrollChangeListener { _, _, scrollY, _, _ ->
            val selectedTabIndex = distances.indexOfFirst { scrollY >= it }
            binding.tabHatDetail.setScrollPosition(selectedTabIndex, 0f, true)
        }
    }
}