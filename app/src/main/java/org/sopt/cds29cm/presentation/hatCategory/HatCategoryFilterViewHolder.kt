package org.sopt.cds29cm.presentation.hatCategory

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.CategoryFilter
import org.sopt.cds29cm.databinding.ItemHatCategoryFilterBinding

class HatCategoryFilterViewHolder(private val binding: ItemHatCategoryFilterBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(filterData: CategoryFilter) {
        with(binding) {
            tvHatCategoryVerticalFilter.text = filterData.filterName
        }
    }
}