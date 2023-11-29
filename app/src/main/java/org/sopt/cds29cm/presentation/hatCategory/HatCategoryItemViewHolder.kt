package org.sopt.cds29cm.presentation.hatCategory

import android.icu.text.DecimalFormat
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.cds29cm.R
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
            if (itemDataList.discount != 0) {
                tvHatCategoryVerticalItemDiscount.text = itemDataList.discount.toString() + "%"
            } else
                tvHatCategoryVerticalItemDiscount.setPadding(0, 0, 0, 0)
            val decimal = DecimalFormat("#,###")
            tvHatCategoryVerticalItemPrice.text = decimal.format(itemDataList.price)
            tvHatCategoryVerticalItemHeart.text = commentDataList.heart
            tvHatCategoryVerticalItemMark.text = commentDataList.mark
            tvHatCategoryVerticalItemMarkPeople.text = commentDataList.markPeople
            if (itemDataList.brand.toString() == "시오르")
                ivHatCategoryVerticalItemHeart.setImageResource(R.drawable.ic_like_on_black_24dp)

/*
            val listener = View.OnClickListener {
                itemDataList.let {
                    onClick(itemDataList)
                }
            }
            ivHatCategoryVerticalItemHeart.setOnClickListener(listener)
*/

            //일단 각자 아이템 클릭 인식 가능, id 추출 가능
            ivHatCategoryVerticalItemHeart.setOnClickListener { // 클릭 이벤트 리스너 처리
                Toast.makeText(
                    it.context,
                    "ViewHolder Clicked -> ID : ${itemDataList.name}",
                    Toast.LENGTH_SHORT
                ).show()



            }


        }
    }

    }
}