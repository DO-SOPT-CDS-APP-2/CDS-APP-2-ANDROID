package org.sopt.cds29cm.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.sopt.cds29cm.databinding.FragmentHomeBinding
import org.sopt.cds29cm.module.ServicePool.homeService
import org.sopt.cds29cm.util.extension.toast

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding : FragmentHomeBinding get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않음" }

    private val viewModel: HomeViewModel by viewModels { HomeViewModelFactory(homeService) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecommendAdapter()
        initNotiaAdapter()
        initIssueAdapter()
        initPopularAdapter()
        initMarronAdapter()
        observeResponseSuccess()

        viewModel.getData()
    }
    private fun initRecommendAdapter(){
        val recommendAdapter = HomeRecommendAdapter(requireContext())
        binding.rvHomeRecommend.adapter = recommendAdapter
        recommendAdapter.setRecommendList(viewModel.mockRecommend)
    }

    private fun initNotiaAdapter(){
        val notiaAdapter = HomeNotiaAdapter(requireContext())
        binding.rvHomeNotia.adapter = notiaAdapter
        notiaAdapter.setRecommendList(viewModel.mockNotia)
    }
    private fun initIssueAdapter(){
        val issueAdapter = HomeIssueAdapter(requireContext())
        binding.rvHomeIssue.adapter = issueAdapter
        issueAdapter.setRecommendList(viewModel.mockIssue)
    }
    private fun initPopularAdapter(){
        val popularAdapter = HomePopularAdapter(requireContext())
        binding.rvHomePopular.adapter = popularAdapter
        popularAdapter.setRecommendList(viewModel.mockPopular)
    }
    private fun initMarronAdapter(){
        val marronAdapter = HomeMarronAdapter(requireContext())
        binding.rvHomeMarron.adapter = marronAdapter
        marronAdapter.setRecommendList(viewModel.mockMarron)
    }
    private fun observeResponseSuccess(){
        viewModel.responseSuccess.observe(viewLifecycleOwner){
            if(it){
                toast("통신 성공")
            }else{
                toast("통신 실패")
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
