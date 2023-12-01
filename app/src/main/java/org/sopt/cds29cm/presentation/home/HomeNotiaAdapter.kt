package org.sopt.cds29cm.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import androidx.lifecycle.LiveData
import org.sopt.cds29cm.data.dto.response.HomeResponseDto
import org.sopt.cds29cm.databinding.ItemHomeNotiaBinding

class HomeNotiaAdapter(context: Context) : RecyclerView.Adapter<HomeNotiaViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var homeNotiaList = mutableListOf<HomeResponseDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNotiaViewHolder {
        val binding = ItemHomeNotiaBinding.inflate(inflater, parent, false)
        return HomeNotiaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeNotiaViewHolder, position: Int) {
        holder.onBind(homeNotiaList[position])
    }

    override fun getItemCount() = homeNotiaList.size

    fun setRecommendList(categoryList: List<HomeResponseDto>) {
        homeNotiaList.clear()
        homeNotiaList.addAll(categoryList)
        notifyDataSetChanged()
    }

}