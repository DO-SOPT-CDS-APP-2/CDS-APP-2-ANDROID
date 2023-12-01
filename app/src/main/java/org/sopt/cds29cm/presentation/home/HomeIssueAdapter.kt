package org.sopt.cds29cm.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import org.sopt.cds29cm.data.dataclass.HomeIssue
import org.sopt.cds29cm.databinding.ItemHomeIssueBinding

class HomeIssueAdapter(context: Context) : RecyclerView.Adapter<HomeIssueViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var homeIssueList: List<HomeIssue> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeIssueViewHolder {
        val binding = ItemHomeIssueBinding.inflate(inflater, parent, false)
        return HomeIssueViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeIssueViewHolder, position: Int) {
        holder.onBind(homeIssueList[position])
    }

    override fun getItemCount() = homeIssueList.size

    fun setRecommendList(categoryList: List<HomeIssue>) {
        this.homeIssueList = categoryList.toList()
        notifyDataSetChanged()
    }
}