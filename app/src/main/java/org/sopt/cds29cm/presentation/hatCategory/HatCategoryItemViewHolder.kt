package org.sopt.cds29cm.presentation.hatCategory

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.dataclass.HatCategoryItemComment
import org.sopt.cds29cm.data.dto.response.ResponseCategoryItemDTO
import org.sopt.cds29cm.databinding.ItemHatCategoryVerticalBinding
import org.sopt.cds29cm.util.extension.setOnSingleClickListener

interface SetOnClickListenerInterface {
    fun listItemClickListener(itemData: String, binding: ItemHatCategoryVerticalBinding)
}


class HatCategoryItemViewHolder(
    val binding: ItemHatCategoryVerticalBinding,
    private val itemClick: (ResponseCategoryItemDTO, Int, HatCategoryItemViewHolder) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {

    private var onClickListener: SetOnClickListenerInterface? = null
    var checkInit:Int=0
    @SuppressLint("SuspiciousIndentation")
    fun onBind(itemData: ResponseCategoryItemDTO, commentDataList: HatCategoryItemComment) {
        binding.ivHatCategoryVerticalItemImage.load(itemData.imageUrl)
        binding.tvHatCategoryVerticalItemBrand.text = itemData.brand
        binding.tvHatCategoryVerticalItemName.text = itemData.name
        if (itemData.discount != 0) {
            binding.tvHatCategoryVerticalItemDiscount.text = itemData.discount.toString() + "%"
        } else
            binding.tvHatCategoryVerticalItemDiscount.setPadding(0, 0, 0, 0)
        val decimal = DecimalFormat("#,###")
        binding.tvHatCategoryVerticalItemPrice.text = decimal.format(itemData.price)
        binding.tvHatCategoryVerticalItemHeart.text = commentDataList.heart
        binding.tvHatCategoryVerticalItemMark.text = commentDataList.mark
        binding.tvHatCategoryVerticalItemMarkPeople.text = commentDataList.markPeople
        binding.tvHatCategoryVerticalItemProductId.text = itemData.productId.toString()
        if(checkInit==0){
            if (itemData.productId==5 ||itemData.productId==3)
                binding.ivHatCategoryVerticalItemHeart.setImageResource(R.drawable.ic_like_on_black_24dp)

        }

        binding.ivHatCategoryVerticalItemHeart.setOnSingleClickListener {
            Log.d("어댑터", "클릭인식")
            itemClick(itemData, itemData.productId, this)
            Log.d("어댑터에서??", "클릭됌??")
/*
            Toast.makeText(
                it.context,
                "ViewHolder Clicked -> ID : ${itemData.productId.toString()}",
                Toast.LENGTH_SHORT
            ).show()
*/


        }
    }


    fun setHeart(a: Boolean) {
        if (a)
            binding.ivHatCategoryVerticalItemHeart.setImageResource(R.drawable.ic_like_on_black_24dp)
        else
            binding.ivHatCategoryVerticalItemHeart.setImageResource(R.drawable.ic_like_off_black_24dp)
    }

    fun listItemClickFunc(pOnClick: SetOnClickListenerInterface) {
        this.onClickListener = pOnClick
    }
}