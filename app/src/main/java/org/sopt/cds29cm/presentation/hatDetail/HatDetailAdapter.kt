package org.sopt.cds29cm.presentation.hatDetail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cds29cm.R
import org.sopt.cds29cm.databinding.ItemDetailAskBinding
import org.sopt.cds29cm.databinding.ItemDetailHeaderBinding
import org.sopt.cds29cm.databinding.ItemDetailInfoBinding
import org.sopt.cds29cm.databinding.ItemDetailRecBinding
import org.sopt.cds29cm.databinding.ItemDetailReviewBinding
import org.sopt.cds29cm.databinding.ItemDetailSizeBinding

class HatDetailAdapter(
    context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val inflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                DetailHeaderViewHolder(ItemDetailHeaderBinding.inflate(inflater, parent, false))
            }

            VIEW_TYPE_INFO -> {
                DetailInfoViewHolder(ItemDetailInfoBinding.inflate(inflater, parent, false))
            }

            VIEW_TYPE_SIZE -> {
                DetailSizeViewHolder(ItemDetailSizeBinding.inflate(inflater, parent, false))
            }

            VIEW_TYPE_REC -> {
                DetailRecViewHolder(ItemDetailRecBinding.inflate(inflater, parent, false))
            }

            VIEW_TYPE_REVIEW -> {
                DetailReviewViewHolder(ItemDetailReviewBinding.inflate(inflater, parent, false))
            }

            VIEW_TYPE_ASK -> {
                DetailAskViewHolder(ItemDetailAskBinding.inflate(inflater, parent, false))
            }


            else -> throw ClassCastException(
                parent.context.getString(R.string.view_type_error_msg, viewType)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DetailHeaderViewHolder -> holder.onBind()
            is DetailInfoViewHolder -> holder.onBind()
            is DetailSizeViewHolder -> holder.onBind()
            is DetailRecViewHolder -> holder.onBind()
            is DetailReviewViewHolder -> holder.onBind()
            is DetailAskViewHolder -> holder.onBind()
        }
    }

    override fun getItemCount() = TOTAL_VIEW_COUNT

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_TYPE_HEADER
            1 -> VIEW_TYPE_INFO
            2 -> VIEW_TYPE_SIZE
            3 -> VIEW_TYPE_REC
            4 -> VIEW_TYPE_REVIEW
            5 -> VIEW_TYPE_ASK
            else -> 6
        }
    }

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_INFO = 1
        private const val VIEW_TYPE_SIZE = 2
        private const val VIEW_TYPE_REC = 3
        private const val VIEW_TYPE_REVIEW = 4
        private const val VIEW_TYPE_ASK = 5

        private const val TOTAL_VIEW_COUNT = 6
    }
}