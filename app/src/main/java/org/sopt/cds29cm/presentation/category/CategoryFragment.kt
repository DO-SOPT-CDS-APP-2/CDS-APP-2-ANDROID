package org.sopt.cds29cm.presentation.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import org.sopt.cds29cm.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {
    private var _binding: FragmentCategoryBinding? = null

    private val binding: FragmentCategoryBinding get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않음" }

    //viewModel 생성
    private val viewModel by viewModels<CategoryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewModel에서 가로 스크롤 카테고리 리스트 가져와서 생성
        val categoryHorizontalAdapter = CategoryHorizontalAdapter(requireContext())
        categoryHorizontalAdapter.setCategoryHorizontalList(viewModel.categoryHorizontalDataList)
        //fragment영역에 적용
        binding.rvCategoryHorizontal.adapter = categoryHorizontalAdapter


        val categoryVerticalLeftAdapter = CategoryVerticalLeftAdapter(requireContext())
        categoryVerticalLeftAdapter.setCategoryVerticalLeftList(viewModel.CategoryVerticalLeftDataList)
        binding.rvCategoryVerticalLeft.adapter=categoryVerticalLeftAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}