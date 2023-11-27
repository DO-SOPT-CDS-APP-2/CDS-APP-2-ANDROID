package org.sopt.cds29cm.presentation.hatCategory

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.CategoryFilter
import org.sopt.cds29cm.databinding.ItemHatCategoryFilterBinding

class HatCategoryFilterAdapter(context: Context) :
    RecyclerView.Adapter<HatCategoryFilterViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var filterList: List<CategoryFilter> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HatCategoryFilterViewHolder {
        val binding = ItemHatCategoryFilterBinding.inflate(inflater, parent, false)
        return HatCategoryFilterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HatCategoryFilterViewHolder, position: Int) {
        holder.onBind(filterList[position])
    }

    override fun getItemCount() = filterList.size

    fun setHatSubCategoryList(categoryList: List<CategoryFilter>) {
        this.filterList = categoryList.toList()
        notifyDataSetChanged()
    }

}
