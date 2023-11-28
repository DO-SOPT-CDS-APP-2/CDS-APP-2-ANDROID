package org.sopt.cds29cm.presentation.hatDetail

import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.cds29cm.data.dataclass.HatDetailEvent
import org.sopt.cds29cm.databinding.ItemRecommendEventBinding

class HatDetailEventViewHolder(
    private val binding: ItemRecommendEventBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: HatDetailEvent) {
        with(binding) {
            ivEvent.load(item.image)
            tvEventTitle.text = item.eventName
            tvEventDate.text = item.eventDate
        }
    }
}