package org.sopt.cds29cm.presentation.hatDetail

import android.os.Bundle
import androidx.activity.viewModels
import coil.load
import com.google.android.material.tabs.TabLayout
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.mock.mockHatDetailBrandList
import org.sopt.cds29cm.data.mock.mockHatDetailEventList
import org.sopt.cds29cm.databinding.ActivityHatDetailBinding
import org.sopt.cds29cm.util.UiState
import org.sopt.cds29cm.util.base.BindingActivity
import org.sopt.cds29cm.util.extension.computeDistanceToView
import org.sopt.cds29cm.util.extension.setOnSingleClickListener
import org.sopt.cds29cm.util.extension.smoothScrollToView
import org.sopt.cds29cm.util.extension.toast

class HatDetailActivity : BindingActivity<ActivityHatDetailBinding>(R.layout.activity_hat_detail) {

    private val tabTextList = listOf("상품정보", "사이즈", "추천", "리뷰", "문의")

    private val viewModel by viewModels<HatDetailViewModel>()

    private var _brandAdapter: HatDetailBrandAdapter? = null
    private val brandAdapter
        get() = requireNotNull(_brandAdapter) { getString(R.string.adapter_not_initialized_error_msg) }

    private var _eventAdapter: HatDetailEventAdapter? = null
    private val eventAdapter
        get() = requireNotNull(_eventAdapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initTabLayoutSelectedListener()
        initOnScrollChangeListener()
        initFabListener()
        setBrandRecyclerView()
        setEventRecyclerView()
        viewModel.getHatDetailFromServer(3)
        observeHatDetailData()
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

    private fun initFabListener() {
        binding.fabHatDetailUp.setOnSingleClickListener {
            binding.svHatDetail.smoothScrollToView(binding.layoutInfo)
            binding.appbarHatDetail.setExpanded(true)
        }
    }

    private fun setBrandRecyclerView() {
        _brandAdapter = HatDetailBrandAdapter()
        binding.rvRecommendBrand.adapter = brandAdapter
        brandAdapter.submitList(mockHatDetailBrandList)
    }

    private fun setEventRecyclerView() {
        _eventAdapter = HatDetailEventAdapter()
        binding.rvRecommendEvent.adapter = eventAdapter
        eventAdapter.submitList(mockHatDetailEventList)
    }

    private fun observeHatDetailData() {
        viewModel.hatDetailState.observe(this) { state ->
            when (state) {
                is UiState.Success -> {
                    if (state.data != null) {
                        with(binding) {
                            ivHatDetailMain.load(state.data.imageUrl)
                            tvHatDetailBrandName.text = state.data.brand
                            tvHatDetailName.text = state.data.name
                            tvHatDetailOriginalPrice.text = String.format("%,d", state.data.price)
                            tvHatDetailSalePercent.text = state.data.discountRate.toString() + "%"
                            tvHatDetailPrice.text = String.format("%,d", state.data.discountPrice)
                            tvHatDetailPoint.text = state.data.point.toString() + "p"
                            tvHatDetailPointPercent.text = "(" + state.data.pointRate.toString() + "%)"
                            ivInfoDetail.load(state.data.description)
                        }
                    }
                }

                is UiState.Failure -> {
                    toast(getString(R.string.server_error))
                }

                is UiState.Empty -> return@observe

                is UiState.Loading -> return@observe
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _brandAdapter = null
        _eventAdapter = null
    }
}