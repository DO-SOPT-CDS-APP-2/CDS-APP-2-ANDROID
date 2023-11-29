package org.sopt.cds29cm.presentation.category

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.dataclass.CategoryVertical
import org.sopt.cds29cm.databinding.ItemCategoryVerticalLeftBinding

class CategoryVerticalLeftViewHolder(private val binding: ItemCategoryVerticalLeftBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(categoryVerticalData: CategoryVertical) {
        with(binding){
            tvCategoryVerticalLeft.text = categoryVerticalData.categoryName
        }
 //       binding.
/*
        if (categoryVerticalData.categoryName.toString() == "악세서리") {
            binding.layoutCategoryVerticalLeft.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
*/
    }
}


