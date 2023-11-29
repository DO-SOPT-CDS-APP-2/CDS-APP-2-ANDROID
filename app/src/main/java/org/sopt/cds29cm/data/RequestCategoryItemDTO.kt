package org.sopt.cds29cm.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestCategoryItemDTO(
    @SerialName("categoryId")
    val categoryId: Int,
)
