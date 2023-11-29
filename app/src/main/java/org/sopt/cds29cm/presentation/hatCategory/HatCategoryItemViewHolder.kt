package org.sopt.cds29cm.presentation.hatCategory

import android.icu.text.DecimalFormat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.cds29cm.data.dataclass.HatCategoryItemComment
import org.sopt.cds29cm.data.dto.response.ResponseCategoryItemDTO
import org.sopt.cds29cm.databinding.ItemHatCategoryVerticalBinding

class HatCategoryItemViewHolder(private val binding: ItemHatCategoryVerticalBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(itemDataList: ResponseCategoryItemDTO, commentDataList: HatCategoryItemComment) {
        with(binding) {
            ivHatCategoryVerticalItemImage.load(itemDataList.imageUrl)
            tvHatCategoryVerticalItemBrand.text = itemDataList.brand
            tvHatCategoryVerticalItemName.text = itemDataList.name
            tvHatCategoryVerticalItemDiscount.text = itemDataList.discount.toString() + "%"
            val decimal = DecimalFormat("#,###")
            tvHatCategoryVerticalItemPrice.text = decimal.format(itemDataList.price)
            tvHatCategoryVerticalItemHeart.text = commentDataList.heart
            tvHatCategoryVerticalItemMark.text = commentDataList.mark
            tvHatCategoryVerticalItemMarkPeople.text = commentDataList.markPeople
        }
    }

}