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
        binding.svHatDetail.setOnScrollChangeListener { _, _, scrollY, _, _ ->
            when {
                scrollY < binding.svHatDetail.computeDistanceToView(binding.layoutSize) -> {
                    binding.tabHatDetail.setScrollPosition(0, 0f, true)
                }

                scrollY >= binding.svHatDetail.computeDistanceToView(binding.layoutSize) &&
                        scrollY < binding.svHatDetail.computeDistanceToView(binding.layoutRecommend) -> {
                    binding.tabHatDetail.setScrollPosition(1, 0f, true)
                }

                scrollY >= binding.svHatDetail.computeDistanceToView(binding.layoutRecommend) &&
                        scrollY < binding.svHatDetail.computeDistanceToView(binding.layoutReview) -> {
                    binding.tabHatDetail.setScrollPosition(2, 0f, true)
                }

                scrollY >= binding.svHatDetail.computeDistanceToView(binding.layoutReview) &&
                        scrollY < binding.svHatDetail.computeDistanceToView(binding.layoutAsk) -> {
                    binding.tabHatDetail.setScrollPosition(3, 0f, true)
                }

                scrollY >= binding.svHatDetail.computeDistanceToView(binding.layoutAsk) -> {
                    binding.tabHatDetail.setScrollPosition(4, 0f, true)
                }
            }
        }
    }
}