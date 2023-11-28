package org.sopt.cds29cm.presentation.hatDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.cds29cm.data.dataclass.HatDetailEvent
import org.sopt.cds29cm.databinding.ItemRecommendEventBinding
import org.sopt.cds29cm.util.extension.ItemDiffCallback

class HatDetailEventAdapter() : ListAdapter<HatDetailEvent, HatDetailEventViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HatDetailEventViewHolder {
        val inflater by lazy { LayoutInflater.from(parent.context) }
        val binding: ItemRecommendEventBinding =
            ItemRecommendEventBinding.inflate(inflater, parent, false)
        return HatDetailEventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HatDetailEventViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = ItemDiffCallback<HatDetailEvent>(
            onItemsTheSame = { old, new -> old.eventName == new.eventName },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}