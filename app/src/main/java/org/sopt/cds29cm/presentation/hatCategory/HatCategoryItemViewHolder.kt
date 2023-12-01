package org.sopt.cds29cm.presentation.hatCategory

import android.icu.text.DecimalFormat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.dataclass.HatCategoryItemComment
import org.sopt.cds29cm.data.dto.response.ResponseCategoryItemDTO
import org.sopt.cds29cm.databinding.ItemHatCategoryVerticalBinding
import org.sopt.cds29cm.util.extension.setOnSingleClickListener

class HatCategoryItemViewHolder(
    val binding: ItemHatCategoryVerticalBinding,
    private val itemClick: (Int, HatCategoryItemViewHolder) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(itemData: ResponseCategoryItemDTO, commentDataList: HatCategoryItemComment) {
        binding.ivHatCategoryVerticalItemImage.load(itemData.imageUrl)
        binding.tvHatCategoryVerticalItemBrand.text = itemData.brand
        binding.tvHatCategoryVerticalItemName.text = itemData.name

        if (itemData.discount != 0) {
            binding.tvHatCategoryVerticalItemDiscount.text = itemData.discount.toString() + "%"
        } else binding.tvHatCategoryVerticalItemDiscount.setPadding(0, 0, 0, 0)

        val decimal = DecimalFormat("#,###")
        binding.tvHatCategoryVerticalItemPrice.text = decimal.format(itemData.price)

        binding.tvHatCategoryVerticalItemHeart.text = commentDataList.heart
        binding.tvHatCategoryVerticalItemMark.text = commentDataList.mark
        binding.tvHatCategoryVerticalItemMarkPeople.text = commentDataList.markPeople

        binding.ivHatCategoryVerticalItemHeart.setOnSingleClickListener {
            itemClick(itemData.productId, this)
        }
    }

    fun setHeart(a: Boolean) {
        if (a) binding.ivHatCategoryVerticalItemHeart.setImageResource(R.drawable.ic_like_on_black_24dp)
        else binding.ivHatCategoryVerticalItemHeart.setImageResource(R.drawable.ic_like_off_black_24dp)
    }
}