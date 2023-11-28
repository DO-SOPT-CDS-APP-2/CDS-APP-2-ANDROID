package org.sopt.cds29cm.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import org.sopt.cds29cm.data.dataclass.HomePopular
import org.sopt.cds29cm.databinding.ItemHomePopularBinding

class HomePopularAdapter(context: Context) : RecyclerView.Adapter<HomePopularViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var homePopularList : List<HomePopular> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePopularViewHolder {
        val binding = ItemHomePopularBinding.inflate(inflater, parent, false)
        return HomePopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomePopularViewHolder, position: Int) {
        holder.onBind(homePopularList[position])
    }

    override fun getItemCount() = homePopularList.size

    fun setRecommendList(categoryList: List<HomePopular>) {
        this.homePopularList = categoryList.toList()
        notifyDataSetChanged()
    }


}