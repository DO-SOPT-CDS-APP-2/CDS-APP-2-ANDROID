package org.sopt.cds29cm.presentation.home

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.HomeMarron
import org.sopt.cds29cm.databinding.ItemHomeMarronBinding

open class HomeMarronViewHolder(private val binding: ItemHomeMarronBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(homeMarron: HomeMarron) {
        binding.ivHomeImage.setImageResource(homeMarron.imageUrl)
        binding.tvHomeBrand.text = homeMarron.brand
        binding.tvHomeBrandSub.text = homeMarron.name
        binding.tvHomeDiscountRate.text = homeMarron.discount
        binding.tvHomeDiscountedPrice.text = homeMarron.price
        binding.ivHomeLike.setImageResource(homeMarron.like)
        binding.tvHomeLikeCount.text = homeMarron.likeCount
    }
}