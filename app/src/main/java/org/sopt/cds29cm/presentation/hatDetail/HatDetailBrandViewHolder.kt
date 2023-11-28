package org.sopt.cds29cm.presentation.hatDetail

import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.cds29cm.data.dataclass.HatDetailBrand
import org.sopt.cds29cm.databinding.ItemRecommendBrandBinding

class HatDetailBrandViewHolder(
    private val binding: ItemRecommendBrandBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: HatDetailBrand) {
        with(binding) {
            ivRecommendItem.load(item.image)
            tvRecommendBrand.text = item.brandName
            tvRecommendName.text = item.hatName
            tvRecommendSalePercent.text = item.discountRate
            tvRecommendPrice.text = String.format("%,d", item.price)
        }
    }
}