package org.sopt.cds29cm.presentation.hatCategory

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.HatCategoryItemComment
import org.sopt.cds29cm.data.dto.response.ResponseCategoryItemDTO
import org.sopt.cds29cm.databinding.ItemHatCategoryVerticalBinding

class HatCategoryItemAdapter(context: Context) :
    RecyclerView.Adapter<HatCategoryItemViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var itemList: List<ResponseCategoryItemDTO> = emptyList()
    private var itemCommentList: List<HatCategoryItemComment> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HatCategoryItemViewHolder {
        val binding = ItemHatCategoryVerticalBinding.inflate(inflater, parent, false)
        return HatCategoryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HatCategoryItemViewHolder, position: Int) {
        holder.onBind(itemList[position], itemCommentList[position])
    }

    override fun getItemCount() = itemList.size

    fun setList(
        categoryList: List<ResponseCategoryItemDTO>,
        markList: List<HatCategoryItemComment>
    ) {
        this.itemList = categoryList.toList()
        this.itemCommentList = markList.toList()
        notifyDataSetChanged()
    }

}
