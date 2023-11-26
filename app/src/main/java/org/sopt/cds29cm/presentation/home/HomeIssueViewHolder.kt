package org.sopt.cds29cm.presentation.home

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.HomeIssue
import org.sopt.cds29cm.data.dataclass.HomeNotia
import org.sopt.cds29cm.databinding.ItemHomeIssueBinding
import org.sopt.cds29cm.databinding.ItemHomeNotiaBinding

open class HomeIssueViewHolder(private val binding: ItemHomeIssueBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(homeIssue: HomeIssue) {
        binding.ivHomeFirst.setImageResource(homeIssue.homeFirstImage)
        binding.tvHomeBrand.text = homeIssue.homeFirstBrand
        binding.tvHomeTitle.text = homeIssue.homeFirstTitle
        binding.ivHomeSecond.setImageResource(homeIssue.homeSecondImage)
        binding.tvHomeSecondBrand.text = homeIssue.homeSecondBrand
        binding.tvHomeDiscountRate.text = homeIssue.homeSecondDiscount
        binding.tvHomeDiscountedPrice.text = homeIssue.homeSecondPrice
        binding.ivHomeThird.setImageResource(homeIssue.homeThirdImage)
        binding.tvHomeThirdBrand.text = homeIssue.homeThirdBrand
        binding.tvHomeThirdDiscountRate.text = homeIssue.homeThirdDiscount
        binding.tvHomeThirdDiscountedPrice.text = homeIssue.homeThirdPrice
    }
}