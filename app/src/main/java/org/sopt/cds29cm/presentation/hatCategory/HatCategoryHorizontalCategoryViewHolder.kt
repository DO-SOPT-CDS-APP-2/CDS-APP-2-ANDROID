package org.sopt.cds29cm.presentation.hatCategory

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.CategoryVertical
import org.sopt.cds29cm.databinding.ItemHatCategoryHorizontalCategoryBinding

class HatCategoryHorizontalCategoryViewHolder(private val binding: ItemHatCategoryHorizontalCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(hatSubCategoryData: CategoryVertical) {
        with(binding) {
            tvHatCategoryHatSubCategory.text = hatSubCategoryData.categoryName
            if (hatSubCategoryData.categoryName == "전체")
                tvHatCategoryHatSubCategory.setTextColor(Color.parseColor("#222222"))
        }
    }

}


