package org.sopt.cds29cm.presentation.home

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.HomeRecommend
import org.sopt.cds29cm.databinding.ItemHomeRecommendBinding

class HomeRecommendViewHolder(private val binding: ItemHomeRecommendBinding) : RecyclerView.ViewHolder(binding.root){
    fun onBind(homeRecommend: HomeRecommend) {
        binding.ivHomeImage.setImageResource(homeRecommend.homeImage)
        binding.tvHomeName.text = homeRecommend.homeName
        binding.tvHomeDiscount.text = homeRecommend.homeDiscount
        binding.tvHomePrice.text = homeRecommend.homePrice
        binding.ivHomeLike.setImageResource(homeRecommend.homeLike)
    }
}