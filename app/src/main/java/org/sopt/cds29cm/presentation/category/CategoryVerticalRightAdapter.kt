package org.sopt.cds29cm.presentation.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.CategoryVertical
import org.sopt.cds29cm.databinding.ItemCategoryVerticalRightBinding

class CategoryVerticalRightAdapter(
    private val itemClick: (String) -> Unit
) :
    RecyclerView.Adapter<CategoryVerticalRightViewHolder>() {

    private var categoryVerticalRightList: List<CategoryVertical> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryVerticalRightViewHolder {
        val inflater by lazy { LayoutInflater.from(parent.context) }
        val binding = ItemCategoryVerticalRightBinding.inflate(inflater, parent, false)
        return CategoryVerticalRightViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: CategoryVerticalRightViewHolder, position: Int) {
        holder.onBind(categoryVerticalRightList[position])
    }

    override fun getItemCount() = categoryVerticalRightList.size

    fun setList(categoryList: List<CategoryVertical>) {
        this.categoryVerticalRightList = categoryList.toList()
        notifyDataSetChanged()
    }
}

