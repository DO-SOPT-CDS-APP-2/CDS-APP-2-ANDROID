package org.sopt.cds29cm.presentation.home

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.HomeMarron
import org.sopt.cds29cm.databinding.ItemHomeMarronBinding

open class HomeMarronViewHolder(private val binding: ItemHomeMarronBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(homeMarron: HomeMarron) {
        binding.run{
            ivHomeImage.setImageResource(homeMarron.imageUrl)
            tvHomeBrand.text = homeMarron.brand
            tvHomeBrandSub.text = homeMarron.name
            tvHomeDiscountRate.text = homeMarron.discount
            tvHomeDiscountedPrice.text = homeMarron.price
            ivHomeLike.setImageResource(homeMarron.like)
            tvHomeLikeCount.text = homeMarron.likeCount
        }
    }
}