package org.sopt.cds29cm.presentation.category

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.CategoryHorizontal
import org.sopt.cds29cm.databinding.ItemCategoryHorizontalBinding

class CategoryHorizontalAdapter(context: Context) :
    RecyclerView.Adapter<CategoryHorizontalViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var categoryHorizontalList: List<CategoryHorizontal> = emptyList()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryHorizontalViewHolder {
        val binding = ItemCategoryHorizontalBinding.inflate(inflater, parent, false)
        return CategoryHorizontalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryHorizontalViewHolder, position: Int) {
        holder.onBind(categoryHorizontalList[position])
    }

    override fun getItemCount()= categoryHorizontalList.size

    fun setList(categoryList: List<CategoryHorizontal>) {
        this.categoryHorizontalList = categoryList.toList()
        notifyDataSetChanged()
    }
}

