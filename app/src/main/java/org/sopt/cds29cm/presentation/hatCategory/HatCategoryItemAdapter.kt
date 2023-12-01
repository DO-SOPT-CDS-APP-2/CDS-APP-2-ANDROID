package org.sopt.cds29cm.presentation.hatCategory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.HatCategoryItemComment
import org.sopt.cds29cm.data.dto.response.ResponseCategoryItemDTO
import org.sopt.cds29cm.databinding.ItemHatCategoryVerticalBinding

class HatCategoryItemAdapter(
    private val itemClick: (Int, HatCategoryItemViewHolder) -> Unit
) : RecyclerView.Adapter<HatCategoryItemViewHolder>() {

    private var itemList: List<ResponseCategoryItemDTO> = emptyList()
    private var itemCommentList: List<HatCategoryItemComment> = emptyList()
    private lateinit var viewHolder: HatCategoryItemViewHolder
    private lateinit var itemDataList: List<ResponseCategoryItemDTO>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HatCategoryItemViewHolder {
        val inflater by lazy { LayoutInflater.from(parent.context) }
        val binding: ItemHatCategoryVerticalBinding =
            ItemHatCategoryVerticalBinding.inflate(inflater, parent, false)
        return HatCategoryItemViewHolder(binding, itemClick)
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