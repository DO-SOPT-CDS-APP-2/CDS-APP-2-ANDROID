package org.sopt.cds29cm.presentation.hatCategory

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.HatBestItem
import org.sopt.cds29cm.databinding.ItemHatCategoryBestHatBinding

class HatCategoryBestItemViewHolder(private val binding: ItemHatCategoryBestHatBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(bestItemDataList: HatBestItem) {
        with(binding) {
            tvHatCategoryBestItemDiscount.text = bestItemDataList.itemDiscount
            tvHatCategoryBestItemName.text = bestItemDataList.itemName
            tvHatCategoryBestItemPrice.text = bestItemDataList.itemPrice
            ivHatCategoryBest.setImageResource(bestItemDataList.itemImage)
            tvHatCategoryBestItemRanking.text = bestItemDataList.itemRanking.toString()
        }
    }

}