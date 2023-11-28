package org.sopt.cds29cm.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.data.dataclass.HomeRecommend
import org.sopt.cds29cm.databinding.ItemHomeRecommendBinding

class HomeRecommendAdapter(context: Context) : RecyclerView.Adapter<HomeRecommendViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var homeRecommendlList: List<HomeRecommend> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecommendViewHolder {
        val binding = ItemHomeRecommendBinding.inflate(inflater, parent, false)
        return HomeRecommendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeRecommendViewHolder, position: Int) {
        holder.onBind(homeRecommendlList[position])
    }

    override fun getItemCount()= homeRecommendlList.size

    fun setRecommendList(categoryList: List<HomeRecommend>) {
        this.homeRecommendlList = categoryList.toList()
        notifyDataSetChanged()
    }
}