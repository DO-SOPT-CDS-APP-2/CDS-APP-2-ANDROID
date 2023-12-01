package org.sopt.cds29cm.presentation.category

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.CategoryVertical
import org.sopt.cds29cm.databinding.ItemCategoryVerticalRightBinding
import org.sopt.cds29cm.presentation.hatCategory.SetOnClickListenerInterface

class CategoryVerticalRightAdapter(
    private val itemClick: (CategoryVertical, String, CategoryVerticalRightViewHolder )-> Unit/*context: Context*/) :
    RecyclerView.Adapter<CategoryVerticalRightViewHolder>() {

    private var CategoryVerticalRightList: List<CategoryVertical> = emptyList()
    private var onClickListener: SetOnClickListenerInterface? = null


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryVerticalRightViewHolder {
        val inflater by lazy { LayoutInflater.from(parent.context) }
        val binding = ItemCategoryVerticalRightBinding.inflate(inflater, parent, false)
        return CategoryVerticalRightViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: CategoryVerticalRightViewHolder, position: Int) {
        holder.onBind(CategoryVerticalRightList[position])
    }

    override fun getItemCount() = CategoryVerticalRightList.size

    fun setList(categoryList: List<CategoryVertical>) {
        this.CategoryVerticalRightList = categoryList.toList()
        notifyDataSetChanged()
    }
}

