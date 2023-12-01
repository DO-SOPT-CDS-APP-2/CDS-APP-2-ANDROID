package org.sopt.cds29cm.data.dataclass

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.cds29cm.data.dto.response.ResponseCategoryItemDTO

@Serializable
data class HatCategoryItem(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<ResponseCategoryItemDTO>,

    )
