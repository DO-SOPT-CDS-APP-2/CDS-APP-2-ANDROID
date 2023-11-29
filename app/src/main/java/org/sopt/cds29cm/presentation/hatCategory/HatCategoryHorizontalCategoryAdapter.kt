package org.sopt.cds29cm.presentation.hatCategory

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.CategoryVertical
import org.sopt.cds29cm.databinding.ItemHatCategoryHorizontalCategoryBinding

class HatCategoryHorizontalCategoryAdapter(context: Context) :
    RecyclerView.Adapter<HatCategoryHorizontalCategoryViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var hatSubCategoryList: List<CategoryVertical> = emptyList()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HatCategoryHorizontalCategoryViewHolder {
        val binding = ItemHatCategoryHorizontalCategoryBinding.inflate(inflater, parent, false)
        return HatCategoryHorizontalCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HatCategoryHorizontalCategoryViewHolder, position: Int) {
        holder.onBind(hatSubCategoryList[position])
    }

    override fun getItemCount() = hatSubCategoryList.size

    fun setList(categoryList: List<CategoryVertical>) {
        this.hatSubCategoryList = categoryList.toList()
        notifyDataSetChanged()
    }

}
