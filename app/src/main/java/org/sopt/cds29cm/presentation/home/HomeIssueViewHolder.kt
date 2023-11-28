package org.sopt.cds29cm.presentation.home

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.HomeIssue
import org.sopt.cds29cm.data.dataclass.HomeNotia
import org.sopt.cds29cm.databinding.ItemHomeIssueBinding
import org.sopt.cds29cm.databinding.ItemHomeNotiaBinding

open class HomeIssueViewHolder(private val binding: ItemHomeIssueBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(homeIssue: HomeIssue) {
        binding.run{
            ivHomeFirst.setImageResource(homeIssue.homeFirstImage)
            tvHomeBrand.text = homeIssue.homeFirstBrand
            tvHomeTitle.text = homeIssue.homeFirstTitle
            ivHomeSecond.setImageResource(homeIssue.homeSecondImage)
            tvHomeSecondBrand.text = homeIssue.homeSecondBrand
            tvHomeDiscountRate.text = homeIssue.homeSecondDiscount
            tvHomeDiscountedPrice.text = homeIssue.homeSecondPrice
            ivHomeThird.setImageResource(homeIssue.homeThirdImage)
            tvHomeThirdBrand.text = homeIssue.homeThirdBrand
            tvHomeThirdDiscountRate.text = homeIssue.homeThirdDiscount
            tvHomeThirdDiscountedPrice.text = homeIssue.homeThirdPrice
        }
    }
}