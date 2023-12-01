package org.sopt.cds29cm.presentation.hatCategory

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.dataclass.HatCategoryItem
import org.sopt.cds29cm.data.dto.response.HeartDTO
import org.sopt.cds29cm.data.dto.response.ResponseCategoryItemDTO
import org.sopt.cds29cm.data.dto.response.ResponseHeartDTO
import org.sopt.cds29cm.databinding.FragmentHatCategoryBinding
import org.sopt.cds29cm.module.ServicePool.itemService
import org.sopt.cds29cm.presentation.category.CategoryFragment
import org.sopt.cds29cm.presentation.hatDetail.HatDetailActivity
import org.sopt.cds29cm.util.extension.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HatCategoryFragment : Fragment() {

    private var _binding: FragmentHatCategoryBinding? = null
    private val binding: FragmentHatCategoryBinding get() = requireNotNull(_binding)

    private val hatCateViewModel by viewModels<HatCategoryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHatCategoryBinding.inflate(inflater, container, false)
        activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.white)
        return binding.root
    }

    private var _adapter: HatCategoryItemAdapter? = null
    private val adapter get() = requireNotNull(_adapter) { "adapter has not initialized" }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initHatCategoryAdapter()
        initBestItemAdapter()
        initItemFilterAdapter()
        initCategoryItemAdapter()
        initBackBtnListener()
    }

    private fun initBackBtnListener() {
        //툴바 백버튼 기능
        binding.ivHatCategoryToolbarBack.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fcv_main, CategoryFragment())
                commit()
            }
        }
    }

    private fun initCategoryItemAdapter() {
        itemService.getCategoryItem().enqueue(object : Callback<HatCategoryItem> {
            override fun onResponse(
                call: Call<HatCategoryItem>, response: Response<HatCategoryItem>
            ) {
                if (response.isSuccessful) {
                    val itemDataList: List<ResponseCategoryItemDTO> =
                        requireNotNull(response.body()!!.data)

                    _adapter = HatCategoryItemAdapter(
                        { productId, holder ->
                            itemService.putHeartItem(productId)
                                .enqueue(object : Callback<ResponseHeartDTO<HeartDTO>> {
                                    override fun onResponse(
                                        call: Call<ResponseHeartDTO<HeartDTO>>,
                                        response: Response<ResponseHeartDTO<HeartDTO>>
                                    ) {
                                        if (response.isSuccessful) {
                                            val nowHeartStatus: Boolean =
                                                response.body()!!.data.isMade
                                            holder.setHeart(nowHeartStatus)
                                        } else {
                                            toast("서버 통신 오류")
                                        }
                                    }

                                    override fun onFailure(
                                        call: Call<ResponseHeartDTO<HeartDTO>>, t: Throwable
                                    ) {
                                        toast("서버 통신 실패")
                                    }
                                })
                        },
                        { productId ->
                            if (productId == 3) {
                                Intent(activity, HatDetailActivity::class.java).apply {
                                    startActivity(this)
                                }
                            }
                        }
                    )

                    adapter.setList(
                        itemDataList, hatCateViewModel.hatItemCommentDataList
                    )
                    binding.rvHatCategoryItem.adapter = adapter
                }
            }

            override fun onFailure(call: Call<HatCategoryItem>, t: Throwable) {
                toast("서버 통신 실패")
            }
        })
    }


    private fun initItemFilterAdapter() {
        val itemFilterAdapter = HatCategoryFilterAdapter(requireContext())
        itemFilterAdapter.setList(hatCateViewModel.filterDataList)
        binding.rvHatCategoryFilter.adapter = itemFilterAdapter
    }

    private fun initBestItemAdapter() {
        val bestItemAdapter = HatCategoryBestItemAdapter(requireContext())
        bestItemAdapter.setList(hatCateViewModel.bestItemDataList)
        binding.rvHatCategoryBestItem.adapter = bestItemAdapter
    }

    private fun initHatCategoryAdapter() {
        val hatSubCategoryAdapter = HatCategoryHorizontalCategoryAdapter(requireContext())
        hatSubCategoryAdapter.setList(hatCateViewModel.subCategoryHatDataList)
        binding.rvHatCategoryHatSubCategory.adapter = hatSubCategoryAdapter
    }

    override fun onDestroyView() {
        _adapter = null
        super.onDestroyView()
    }
}