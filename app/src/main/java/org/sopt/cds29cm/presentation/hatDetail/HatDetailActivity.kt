package org.sopt.cds29cm.presentation.hatDetail

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayout
import org.sopt.cds29cm.R
import org.sopt.cds29cm.databinding.ActivityHatDetailBinding
import org.sopt.cds29cm.util.base.BindingActivity
import org.sopt.cds29cm.util.extension.scrollToView
import org.sopt.cds29cm.util.extension.smoothScrollToView

class HatDetailActivity : BindingActivity<ActivityHatDetailBinding>(R.layout.activity_hat_detail),
    TabLayout.OnTabSelectedListener, View.OnScrollChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when (tab?.position) {
            0 -> binding.svHatDetail.smoothScrollToView(binding.layoutHatDetail)
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) = Unit
    override fun onTabReselected(tab: TabLayout.Tab?) = Unit


    override fun onScrollChange(p0: View?, p1: Int, scrollY: Int, p3: Int, p4: Int) {
        when {
            scrollY == 0
            -> {
                binding.tablayout.setScrollPosition(0, 0f, true)
            }
            scrollY >= binding.nestedScrollview.computeDistanceToView(binding.depositTv)  &&
                    scrollY < binding.nestedScrollview.computeDistanceToView(binding.loanTv)
            -> binding.tablayout.setScrollPosition(1, 0f, true)
            scrollY >= binding.nestedScrollview.computeDistanceToView(binding.loanTv) &&
                    scrollY < binding.nestedScrollview.computeDistanceToView(binding.serviceTv)
            ->  binding.tablayout.setScrollPosition(2, 0f, true)
            scrollY >= binding.nestedScrollview.computeDistanceToView(binding.serviceTv) &&
                    scrollY < binding.nestedScrollview.computeDistanceToView(binding.partnershipTv)
            ->   binding.tablayout.setScrollPosition(3, 0f, true)
            scrollY >= binding.nestedScrollview.computeDistanceToView(binding.partnershipTv) &&
                    scrollY < binding.nestedScrollview.computeDistanceToView(binding.miniTv)
            ->   binding.tablayout.setScrollPosition(4, 0f, true)
        }

        if(!binding.nestedScrollview.canScrollVertically(1))  binding.tablayout.setScrollPosition(5, 0f, true)

    }
}