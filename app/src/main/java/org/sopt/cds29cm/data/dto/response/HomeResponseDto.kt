package org.sopt.cds29cm.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeResponseDto(
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("brand")
    val brand: String,
    @SerialName("name")
    val name: String,
    @SerialName("discount")
    val discount: Int,
    @SerialName("Price")
    val Price: Int,
)