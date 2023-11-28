package org.sopt.cds29cm.presentation.home

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.HomeNotia
import org.sopt.cds29cm.databinding.ItemHomeNotiaBinding

open class HomeNotiaViewHolder(private val binding: ItemHomeNotiaBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(homeNotia: HomeNotia) {
        binding.run{
            ivHomeImage.setImageResource(homeNotia.imageUrl)
            tvHomeBrand.text = homeNotia.brand
            tvHomeBrandSub.text = homeNotia.name
            tvHomeDiscountRate.text = homeNotia.discount
            binding.tvHomeDiscountedPrice.text = homeNotia.price
            binding.ivHomeLike.setImageResource(homeNotia.like)
            binding.tvHomeLikeCount.text = homeNotia.likeCount
        }
    }
}