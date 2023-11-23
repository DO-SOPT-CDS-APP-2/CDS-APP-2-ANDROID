package org.sopt.cds29cm.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarronResponseDto(
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("brand")
    val brand: String,
    @SerialName("name")
    val name: String,
    @SerialName("discountRate")
    val discountRate: Int,
    @SerialName("discountedPrice")
    val discountedPrice: Int,
    @SerialName("like")
    val like: Boolean,
    @SerialName("likeCount")
    val likeCount: Int,
)