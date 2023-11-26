package org.sopt.cds29cm.presentation.home

import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.HomePopular
import org.sopt.cds29cm.databinding.ItemHomePopularBinding

open class HomePopularViewHolder(private val binding: ItemHomePopularBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(homePopular: HomePopular) {
        binding.ivHomePopular.setImageResource(homePopular.imageUrl)
    }
}