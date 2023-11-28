package org.sopt.cds29cm.presentation.hatDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.cds29cm.data.dataclass.HatDetailBrand
import org.sopt.cds29cm.databinding.ItemRecommendBrandBinding
import org.sopt.cds29cm.util.extension.ItemDiffCallback

class HatDetailBrandAdapter() : ListAdapter<HatDetailBrand, HatDetailBrandViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HatDetailBrandViewHolder {
        val inflater by lazy { LayoutInflater.from(parent.context) }
        val binding: ItemRecommendBrandBinding =
            ItemRecommendBrandBinding.inflate(inflater, parent, false)
        return HatDetailBrandViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HatDetailBrandViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = ItemDiffCallback<HatDetailBrand>(
            onItemsTheSame = { old, new -> old.hatName == new.hatName },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}