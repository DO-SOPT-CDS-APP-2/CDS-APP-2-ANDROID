package org.sopt.cds29cm.presentation.category

import org.sopt.cds29cm.data.CategoryHorizontal
import org.sopt.cds29cm.databinding.ItemCategoryHorizontalBinding
import androidx.recyclerview.widget.RecyclerView

class CategoryHorizontalViewHolder(private val binding: ItemCategoryHorizontalBinding) :
    RecyclerView.ViewHolder(binding.root)
    {
        fun onBind(categoryHorizontalData: CategoryHorizontal) {
            binding.tvCategoryHorizontal.text = categoryHorizontalData.categoryName
            binding.ivCategoryHorizontal.setImageResource(categoryHorizontalData.categoryImage)
        }
    }
