package org.sopt.cds29cm.presentation.hatCategory

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.BestItem
import org.sopt.cds29cm.databinding.ItemHatCategoryBestHatBinding

class HatCategoryBestItemAdapter(context: Context) :
    RecyclerView.Adapter<HatCategoryBestItemViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var bestItemList: List<BestItem> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HatCategoryBestItemViewHolder {
        val binding = ItemHatCategoryBestHatBinding.inflate(inflater, parent, false)
        return HatCategoryBestItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HatCategoryBestItemViewHolder, position: Int) {
        holder.onBind(bestItemList[position])
    }

    override fun getItemCount() = bestItemList.size

    fun setHatSubCategoryList(categoryList: List<BestItem>) {
        this.bestItemList = categoryList.toList()
        notifyDataSetChanged()
    }

}
