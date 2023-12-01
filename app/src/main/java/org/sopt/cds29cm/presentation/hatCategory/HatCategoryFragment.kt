package org.sopt.cds29cm.presentation.hatCategory

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HatCategoryFragment : Fragment() {
    private var _binding: FragmentHatCategoryBinding? = null
    private val binding: FragmentHatCategoryBinding get() = requireNotNull(_binding)
    private val hatCateViewModel by viewModels<HatCategoryViewModel>()
    private var itemsAdapter: HatCategoryItemAdapter? = null
    private var itemsViewHolder: HatCategoryItemViewHolder? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHatCategoryBinding.inflate(inflater, container, false)
        activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.white)
        return binding.root
    }

    private var _adapter: HatCategoryItemAdapter? = null
    lateinit private var fragContext: Context
    private val adapter get() = requireNotNull(_adapter) { "adapter has not initialized" }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding)
        {
            initHatCategoryAdapter()

            initBestItemAdapter()

            initItemFilterAdapter()

            initCategoryItemAdapter()

            //툴바 백버튼 기능
            ivHatCategoryToolbarBack.setOnClickListener {
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.fcv_main, CategoryFragment())
                    commit()
                }

            }

        }


    }

    private fun FragmentHatCategoryBinding.initCategoryItemAdapter() {
        itemService.getCategoryItem()
            .enqueue(object : Callback<HatCategoryItem> {
                override fun onResponse(
                    call: Call<HatCategoryItem>,
                    response: Response<HatCategoryItem>
                ) {
                    if (response.isSuccessful) {
                        val itemDataList: List<ResponseCategoryItemDTO> =
                            requireNotNull(response.body()!!.data)

                        _adapter =
                            HatCategoryItemAdapter { ResponseCategoryItemDTO, position, holder ->
                                itemService.putHeartItem(position)
                                    .enqueue(object : Callback<ResponseHeartDTO<HeartDTO>> {
                                        override fun onResponse(
                                            call: Call<ResponseHeartDTO<HeartDTO>>,
                                            response: Response<ResponseHeartDTO<HeartDTO>>
                                        ) {
                                            if (response.isSuccessful) {
                                                val nowHeartStatus: Boolean =
                                                    response.body()!!.data.isMade
                                                if (nowHeartStatus) {
                                                    holder.setHeart(nowHeartStatus)
                                                }
                                                //하트 켜지도록
                                                else {
                                                    holder.setHeart(nowHeartStatus)
                                                }
                                            } else {
                                                Toast.makeText(
                                                    context,
                                                    "서버 통신 실패",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }

                                        override fun onFailure(
                                            call: Call<ResponseHeartDTO<HeartDTO>>,
                                            t: Throwable
                                        ) {
                                            Toast.makeText(
                                                context,
                                                "서버 통신 실패",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    })
                            }

                        adapter.setList(
                            itemDataList,
                            hatCateViewModel.hatItemCommentDataList
                        )
                        rvHatCategoryItem.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<HatCategoryItem>, t: Throwable) {
                    Toast.makeText(
                        context,
                        "서버 통신 실패",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            })
    }


    private fun FragmentHatCategoryBinding.initItemFilterAdapter() {
        val itemFilterAdapter = HatCategoryFilterAdapter(requireContext())
        itemFilterAdapter.setList(hatCateViewModel.filterDataList)
        rvHatCategoryFilter.adapter = itemFilterAdapter
    }

    private fun FragmentHatCategoryBinding.initBestItemAdapter() {
        val bestItemAdapter = HatCategoryBestItemAdapter(requireContext())
        bestItemAdapter.setList(hatCateViewModel.bestItemDataList)
        rvHatCategoryBestItem.adapter = bestItemAdapter
    }

    private fun FragmentHatCategoryBinding.initHatCategoryAdapter() {
        val hatSubCategoryAdapter = HatCategoryHorizontalCategoryAdapter(requireContext())
        hatSubCategoryAdapter.setList(hatCateViewModel.subCategoryHatDataList)
        rvHatCategoryHatSubCategory.adapter = hatSubCategoryAdapter
    }

    override fun onDestroyView() {
        _adapter = null
        super.onDestroyView()
    }
}