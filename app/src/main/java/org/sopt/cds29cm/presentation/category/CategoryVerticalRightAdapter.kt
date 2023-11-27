package org.sopt.cds29cm.presentation.category

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.CategoryVertical
import org.sopt.cds29cm.databinding.ItemCategoryVerticalRightBinding

class CategoryVerticalRightAdapter(context: Context) :
    RecyclerView.Adapter<CategoryVerticalRightViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var CategoryVerticalRightList: List<CategoryVertical> = emptyList()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryVerticalRightViewHolder {
        val binding = ItemCategoryVerticalRightBinding.inflate(inflater, parent, false)
        return CategoryVerticalRightViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryVerticalRightViewHolder, position: Int) {
        holder.onBind(CategoryVerticalRightList[position])
    }

    override fun getItemCount() = CategoryVerticalRightList.size

    fun setCategoryVerticalRightList(categoryList: List<CategoryVertical>) {
        this.CategoryVerticalRightList = categoryList.toList()
        notifyDataSetChanged()
    }
}

