package org.sopt.cds29cm.presentation.category

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.CategoryVertical
import org.sopt.cds29cm.databinding.ItemCategoryVerticalRightBinding
import org.sopt.cds29cm.util.extension.setOnSingleClickListener

class CategoryVerticalRightViewHolder(
    private val binding: ItemCategoryVerticalRightBinding,
    private val itemClick: (CategoryVertical, String, CategoryVerticalRightViewHolder) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(categoryData: CategoryVertical) {
        with(binding) {
            tvCategoryVerticalRight.textSize = categoryData.fontSize.toFloat()
            tvCategoryVerticalRight.setTextAppearance(categoryData.font)
            tvCategoryVerticalRight.text = categoryData.categoryName

            binding.layoutCategoryVerticalRight.setOnSingleClickListener {
                itemClick(
                    categoryData,
                    categoryData.categoryName,
                    this@CategoryVerticalRightViewHolder
                )
            }
        }
    }
}


