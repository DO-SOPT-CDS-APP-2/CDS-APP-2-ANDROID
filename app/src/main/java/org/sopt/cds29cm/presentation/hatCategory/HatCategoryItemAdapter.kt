package org.sopt.cds29cm.presentation.hatCategory

import android.icu.text.DecimalFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.dataclass.HatCategoryItemComment
import org.sopt.cds29cm.data.dto.response.ResponseCategoryItemDTO
import org.sopt.cds29cm.databinding.ItemHatCategoryVerticalBinding

class HatCategoryItemAdapter(
    private val itemClick: (ResponseCategoryItemDTO, Int, HatCategoryItemViewHolder) -> Unit
) : RecyclerView.Adapter<HatCategoryItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HatCategoryItemViewHolder {
        val inflater by lazy { LayoutInflater.from(parent.context) }
        val binding: ItemHatCategoryVerticalBinding =
            ItemHatCategoryVerticalBinding.inflate(inflater, parent, false)
        return HatCategoryItemViewHolder(binding, itemClick)
    }


    private var itemList: List<ResponseCategoryItemDTO> = emptyList()
    private var itemCommentList: List<HatCategoryItemComment> = emptyList()
    private lateinit var viewHolder: HatCategoryItemViewHolder
    private lateinit var itemDataList: List<ResponseCategoryItemDTO>
    private var onClickListener: SetOnClickListenerInterface? = null
     var itemData:ResponseCategoryItemDTO?=null
    inner class ViewHolder(private val itemViewBinding: ItemHatCategoryVerticalBinding/*private val itemViewBinding: ItemHatCategoryVerticalBinding*/) :
        RecyclerView.ViewHolder(itemViewBinding.root/*itemViewBinding.root*/) {
        fun bind(
            mItemData: ResponseCategoryItemDTO,
            commentDataList: HatCategoryItemComment /*listener: OnClickListener, item:ResponseCategoryItemDTO*//*productId: String*/
        ) {
            itemData=mItemData
            with(itemViewBinding) {
                ivHatCategoryVerticalItemImage.load(mItemData.imageUrl)
                tvHatCategoryVerticalItemBrand.text = mItemData.brand
                tvHatCategoryVerticalItemName.text = mItemData.name
                if (mItemData.discount != 0) {
                    tvHatCategoryVerticalItemDiscount.text = mItemData.discount.toString() + "%"
                } else
                    tvHatCategoryVerticalItemDiscount.setPadding(0, 0, 0, 0)
                val decimal = DecimalFormat("#,###")
                tvHatCategoryVerticalItemPrice.text = decimal.format(mItemData.price)
                tvHatCategoryVerticalItemHeart.text = commentDataList.heart
                tvHatCategoryVerticalItemMark.text = commentDataList.mark
                tvHatCategoryVerticalItemMarkPeople.text = commentDataList.markPeople
                if (mItemData.brand.toString() == "시오르")
                    ivHatCategoryVerticalItemHeart.setImageResource(R.drawable.ic_like_on_black_24dp)
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    itemViewBinding.ivHatCategoryVerticalItemHeart.setOnClickListener {
                        onClickListener?.listItemClickListener(
                            mItemData.productId.toString(),
                            itemViewBinding
                        )
                    }
                }

            }
        }
    }

    override fun onBindViewHolder(holder: HatCategoryItemViewHolder, position: Int) {
        viewHolder = holder
        holder.onBind(itemList[position], itemCommentList[position])
    }

    override fun getItemCount() = itemList.size

    fun setList(
        categoryList: List<ResponseCategoryItemDTO>,
        markList: List<HatCategoryItemComment>
    ) {
        this.itemList = categoryList.toList()
        itemDataList = categoryList.toList()
        this.itemCommentList = markList.toList()
        notifyDataSetChanged()
    }

}