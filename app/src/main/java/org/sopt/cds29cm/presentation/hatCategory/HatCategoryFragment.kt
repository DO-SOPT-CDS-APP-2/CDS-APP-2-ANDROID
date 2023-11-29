package org.sopt.cds29cm.presentation.hatCategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.sopt.cds29cm.data.dataclass.HatCategoryItem
import org.sopt.cds29cm.databinding.FragmentHatCategoryBinding
import org.sopt.cds29cm.module.ServicePool.itemService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HatCategoryFragment : Fragment() {
    private var _binding: FragmentHatCategoryBinding? = null
    private val binding: FragmentHatCategoryBinding get() = requireNotNull(_binding)
    private val hatCateViewModel by viewModels<HatCategoryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHatCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding)
        {
            initHatCategoryAdapter()

            initBestItemAdapter()

            initItemFilterAdapter()

            //item 불러오기
            itemService.getCategoryItem()
                .enqueue(object : Callback<HatCategoryItem> {
                    override fun onResponse(
                        call: Call<HatCategoryItem>,
                        response: Response<HatCategoryItem>
                    ) {

                        if (response.isSuccessful) {
                            val itemDataList: HatCategoryItem = requireNotNull(response.body())
                            //어댑터로 끼워넣기
                            val itemAdapter = HatCategoryItemAdapter(requireContext())
                            itemAdapter.setList(itemDataList.data)
                            rvHatCategoryItem.adapter = itemAdapter
                            /*
                                                        //heart 상태 불러오기
                                                        itemService.putHeartItem(1, data.productId)
                                                            .enqueue(object :retrofit2.Callback<ResponseHeartDTO>{
                                                                override fun onResponse(
                                                                    call: Call<ResponseHeartDTO>,
                                                                    response: Response<ResponseHeartDTO>
                                                                ) {
                                                                    if(response.isSuccessful){
                                                                        Toast.makeText(context, "하트 통신 됌", Toast.LENGTH_SHORT).show()
                                                                    }
                                                                }

                                                                override fun onFailure(
                                                                    call: Call<ResponseHeartDTO>,
                                                                    t: Throwable
                                                                ) {
                                                                    TODO("Not yet implemented")
                                                                }
                                                            })
                            */


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
}