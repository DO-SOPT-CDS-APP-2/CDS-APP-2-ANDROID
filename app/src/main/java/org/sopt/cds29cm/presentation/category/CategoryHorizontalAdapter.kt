package org.sopt.cds29cm.presentation.category

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.CategoryHorizontal
import org.sopt.cds29cm.databinding.ItemCategoryHorizontalBinding

class CategoryHorizontalAdapter(context: Context) :
    RecyclerView.Adapter<CategoryHorizontalViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var CategoryHorizontalList: List<CategoryHorizontal> = emptyList()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryHorizontalViewHolder {
        val binding = ItemCategoryHorizontalBinding.inflate(inflater, parent, false)
        return CategoryHorizontalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryHorizontalViewHolder, position: Int) {
        holder.onBind(CategoryHorizontalList[position])
    }

    override fun getItemCount()= CategoryHorizontalList.size

    fun setCategoryHorizontalList(categoryList: List<CategoryHorizontal>) {
        this.CategoryHorizontalList = categoryList.toList()
        notifyDataSetChanged()
    }
}

