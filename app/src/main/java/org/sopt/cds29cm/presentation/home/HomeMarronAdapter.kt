package org.sopt.cds29cm.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import org.sopt.cds29cm.data.dataclass.HomeMarron
import org.sopt.cds29cm.databinding.ItemHomeMarronBinding

class HomeMarronAdapter(context: Context) : RecyclerView.Adapter<HomeMarronViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var homeMarronList : List<HomeMarron> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMarronViewHolder {
        val binding = ItemHomeMarronBinding.inflate(inflater, parent, false)
        return HomeMarronViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeMarronViewHolder, position: Int) {
        holder.onBind(homeMarronList[position])
    }

    override fun getItemCount() = homeMarronList.size

    fun setRecommendList(categoryList: List<HomeMarron>) {
        this.homeMarronList = categoryList.toList()
        notifyDataSetChanged()
    }


}