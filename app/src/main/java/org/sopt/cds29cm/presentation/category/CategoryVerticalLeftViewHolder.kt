package org.sopt.cds29cm.presentation.category

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.CategoryVertical
import org.sopt.cds29cm.databinding.ItemCategoryVerticalLeftBinding

class CategoryVerticalLeftViewHolder(private val binding:ItemCategoryVerticalLeftBinding) :
    RecyclerView.ViewHolder(binding.root)
    {
        fun onBind(categoryHorizontalData: CategoryVertical) {
            binding.tvCategoryVerticalLeft.text = categoryHorizontalData.categoryName
        }
    }


