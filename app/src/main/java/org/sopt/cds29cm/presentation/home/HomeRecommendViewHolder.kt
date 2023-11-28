package org.sopt.cds29cm.presentation.home

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.HomeRecommend
import org.sopt.cds29cm.databinding.ItemHomeRecommendBinding

class HomeRecommendViewHolder(private val binding: ItemHomeRecommendBinding) : RecyclerView.ViewHolder(binding.root){
    fun onBind(homeRecommend: HomeRecommend) {
        binding.run{
            ivHomeImage.setImageResource(homeRecommend.homeImage)
            tvHomeName.text = homeRecommend.homeName
            tvHomeDiscount.text = homeRecommend.homeDiscount
            tvHomePrice.text = homeRecommend.homePrice
            ivHomeLike.setImageResource(homeRecommend.homeLike)
        }
    }
}