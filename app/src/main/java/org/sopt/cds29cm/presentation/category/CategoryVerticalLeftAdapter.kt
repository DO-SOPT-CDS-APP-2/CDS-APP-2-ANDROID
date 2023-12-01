package org.sopt.cds29cm.presentation.category

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.CategoryVertical
import org.sopt.cds29cm.databinding.ItemCategoryVerticalLeftBinding

class CategoryVerticalLeftAdapter(context: Context) :
    RecyclerView.Adapter<CategoryVerticalLeftViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var categoryVerticalLeftList: List<CategoryVertical> = emptyList()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryVerticalLeftViewHolder {
        val binding = ItemCategoryVerticalLeftBinding.inflate(inflater, parent, false)
        return CategoryVerticalLeftViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryVerticalLeftViewHolder, position: Int) {
        holder.onBind(categoryVerticalLeftList[position])
    }

    override fun getItemCount() = categoryVerticalLeftList.size

    fun setList(categoryList: List<CategoryVertical>) {
        this.categoryVerticalLeftList = categoryList.toList()
        notifyDataSetChanged()
    }
}

