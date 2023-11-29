package org.sopt.cds29cm.presentation.category

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.CategoryVertical
import org.sopt.cds29cm.databinding.ItemCategoryVerticalRightBinding

class CategoryVerticalRightViewHolder(private val binding: ItemCategoryVerticalRightBinding) :
    RecyclerView.ViewHolder(binding.root)
    {
        fun onBind(categoryData: CategoryVertical) {
            binding.tvCategoryVerticalRight.text = categoryData.categoryName
        }
    }


