package org.sopt.cds29cm.presentation.home

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.HomeNotia
import org.sopt.cds29cm.databinding.ItemHomeNotiaBinding

open class HomeNotiaViewHolder(private val binding: ItemHomeNotiaBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(homeNotia: HomeNotia) {
        binding.ivHomeImage.setImageResource(homeNotia.imageUrl)
        binding.tvHomeBrand.text = homeNotia.brand
        binding.tvHomeBrandSub.text = homeNotia.name
        binding.tvHomeDiscountRate.text = homeNotia.discount
        binding.tvHomeDiscountedPrice.text = homeNotia.price
        binding.ivHomeLike.setImageResource(homeNotia.like)
        binding.tvHomeLikeCount.text = homeNotia.likeCount
    }
}