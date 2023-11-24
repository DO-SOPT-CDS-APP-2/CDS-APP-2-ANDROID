package org.sopt.cds29cm.presentation.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import org.sopt.cds29cm.data.mock.HomeRecommendViewModel
import org.sopt.cds29cm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    private val viewModel by viewModels<HomeRecommendViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recommendAdapter = HomeRecommendAdapter(requireContext())
        binding.rvHomeRecommend.adapter = recommendAdapter
        recommendAdapter.setRecommendList(viewModel.mockRecommend)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
