package org.sopt.cds29cm.presentation.category

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.dataclass.CategoryVertical
import org.sopt.cds29cm.databinding.ItemCategoryVerticalLeftBinding

class CategoryVerticalLeftViewHolder(private val binding: ItemCategoryVerticalLeftBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("ResourceAsColor")
    fun onBind(categoryVerticalData: CategoryVertical) {
        with(binding){
            tvCategoryVerticalLeft.text = categoryVerticalData.categoryName
            if (categoryVerticalData.categoryName == "액세서리") {
                tvCategoryVerticalLeft.setTextAppearance(R.style.TextAppearance_Kor_Bold)
                itemCategoryVerticalLeft.setBackgroundColor(Color.parseColor("#FFFFFF"))
            }
        }
    }
}


