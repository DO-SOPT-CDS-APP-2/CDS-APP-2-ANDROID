package org.sopt.cds29cm.presentation.category

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.CategoryVertical
import org.sopt.cds29cm.databinding.ItemCategoryVerticalLeftBinding

class CategoryVerticalLeftAdapter(context: Context) :
    RecyclerView.Adapter<CategoryVerticalLeftViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var CategoryVerticalLeftList: List<CategoryVertical> = emptyList()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryVerticalLeftViewHolder {
        val binding = ItemCategoryVerticalLeftBinding.inflate(inflater, parent, false)
        return CategoryVerticalLeftViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryVerticalLeftViewHolder, position: Int) {
        holder.onBind(CategoryVerticalLeftList[position])
    }

    override fun getItemCount() = CategoryVerticalLeftList.size

    fun setCategoryVerticalLeftList(categoryList: List<CategoryVertical>) {
        this.CategoryVerticalLeftList = categoryList.toList()
        notifyDataSetChanged()
    }
}

