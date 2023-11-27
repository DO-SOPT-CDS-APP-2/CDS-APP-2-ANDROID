package org.sopt.cds29cm.presentation.hatCategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.cds29cm.databinding.FragmentHatCategoryBinding

class HatCategoryFragment : Fragment() {
    private var _binding: FragmentHatCategoryBinding? = null
    private val binding: FragmentHatCategoryBinding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHatCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

}