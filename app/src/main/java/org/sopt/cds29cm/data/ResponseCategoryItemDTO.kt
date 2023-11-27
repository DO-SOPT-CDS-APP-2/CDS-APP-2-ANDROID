package org.sopt.cds29cm.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseCategoryItemDTO(
    @SerialName("productId")
    val productId: Int,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("brand")
    val brand: String,
    @SerialName("name")
    val name: String,
    @SerialName("discount")
    val discount: Int,
    @SerialName("price")
    val price: Int,

    )