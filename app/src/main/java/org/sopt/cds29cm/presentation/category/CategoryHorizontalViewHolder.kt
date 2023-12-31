package org.sopt.cds29cm.presentation.category

import org.sopt.cds29cm.data.dataclass.CategoryHorizontal
import org.sopt.cds29cm.databinding.ItemCategoryHorizontalBinding
import androidx.recyclerview.widget.RecyclerView

class CategoryHorizontalViewHolder(private val binding: ItemCategoryHorizontalBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(categoryHorizontalData: CategoryHorizontal) {
        with(binding) {
            tvCategoryHorizontal.text = categoryHorizontalData.categoryName
            ivCategoryHorizontal.setImageResource(categoryHorizontalData.categoryImage)
            if(categoryHorizontalData.categoryName=="PT")
                tvCategoryHorizontal.textSize= 9F
        }
    }
}
