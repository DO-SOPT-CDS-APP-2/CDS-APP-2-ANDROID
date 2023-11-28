package org.sopt.cds29cm.presentation.hatCategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.sopt.cds29cm.databinding.FragmentHatCategoryBinding

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
            val hatSubCategoryAdapter = HatCategoryHorizontalCategoryAdapter(requireContext())
            hatSubCategoryAdapter.setList(hatCateViewModel.subCategoryHatDataList)
            rvHatCategoryHatSubCategory.adapter = hatSubCategoryAdapter

            val bestItemAdapter = HatCategoryBestItemAdapter(requireContext())
            bestItemAdapter.setList(hatCateViewModel.bestItemDataList)
            rvHatCategoryBestItem.adapter = bestItemAdapter

            val itemFilterAdapter = HatCategoryFilterAdapter(requireContext())
            itemFilterAdapter.setList(hatCateViewModel.filterDataList)
            rvHatCategoryFilter.adapter = itemFilterAdapter

        }

    }
}