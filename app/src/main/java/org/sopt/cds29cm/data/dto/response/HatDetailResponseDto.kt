package org.sopt.cds29cm.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HatDetailResponseDto(
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("brand")
    val brand: String,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Int,
    @SerialName("discountRate")
    val discountRate: Int,
    @SerialName("discountedPrice")
    val discountedPrice: Int,
    @SerialName("point")
    val point: Int,
    @SerialName("pointRate")
    val pointRate: Int,
    @SerialName("description")
    val description: String,
)