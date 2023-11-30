package org.sopt.cds29cm.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import org.sopt.cds29cm.data.dto.response.HomeResponseDto
import org.sopt.cds29cm.databinding.FragmentHomeBinding
import org.sopt.cds29cm.module.ServicePool.homeService
import org.sopt.cds29cm.util.extension.toast

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않음" }

    private val viewModel: HomeViewModel by viewModels { HomeViewModelFactory(homeService) }
    private lateinit var dataAdapter: HomeNotiaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNotiaAdapter()

        initRecommendAdapter()
        initIssueAdapter()
        initPopularAdapter()
        initMarronAdapter()
        observeResponseSuccess()

        viewModel.getData()
    }

    private fun initRecommendAdapter() {
        val recommendAdapter = HomeRecommendAdapter(requireContext())
        binding.rvHomeRecommend.adapter = recommendAdapter
        recommendAdapter.setRecommendList(viewModel.mockRecommend)
    }

    private fun initIssueAdapter() {
        val issueAdapter = HomeIssueAdapter(requireContext())
        binding.rvHomeIssue.adapter = issueAdapter
        issueAdapter.setRecommendList(viewModel.mockIssue)
    }

    private fun initPopularAdapter() {
        val popularAdapter = HomePopularAdapter(requireContext())
        binding.rvHomePopular.adapter = popularAdapter
        popularAdapter.setRecommendList(viewModel.mockPopular)
    }

    private fun initMarronAdapter() {
        val marronAdapter = HomeMarronAdapter(requireContext())
        binding.rvHomeMarron.adapter = marronAdapter
        marronAdapter.setRecommendList(viewModel.mockMarron)
    }

    // 서버 통신한 것을 "View"에서 어댑터 연결해주기
    private fun initNotiaAdapter() {
        dataAdapter = HomeNotiaAdapter(requireContext())
        binding.rvHomeNotia.adapter = dataAdapter
    }

    private fun setDataList(serverData: List<HomeResponseDto>) {
        dataAdapter.setRecommendList(serverData)
    }

    private fun observeResponseSuccess() {
        viewModel.responseSuccess.observe(viewLifecycleOwner) {
            if (it) {
                toast("통신 성공")
                val data = viewModel.dataResult.value
                setDataList(listOf(data) as List<HomeResponseDto>)
            } else {
                toast("통신 실패")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
