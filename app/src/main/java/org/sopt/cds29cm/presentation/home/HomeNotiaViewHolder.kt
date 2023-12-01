package org.sopt.cds29cm.presentation.home

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.cds29cm.data.dto.response.HomeResponseDto
import org.sopt.cds29cm.databinding.ItemHomeNotiaBinding

open class HomeNotiaViewHolder(private val binding: ItemHomeNotiaBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(homeResponseDto: HomeResponseDto) {
        binding.run {
            ivHomeImage.load(homeResponseDto.imageUrl)
            tvHomeBrand.text = homeResponseDto.brand
            tvHomeSub.text = homeResponseDto.name
            tvHomeDiscountRate.text = homeResponseDto.discount.toString()
            binding.tvHomeDiscountedPrice.text = homeResponseDto.price.toString()
        }
    }
}