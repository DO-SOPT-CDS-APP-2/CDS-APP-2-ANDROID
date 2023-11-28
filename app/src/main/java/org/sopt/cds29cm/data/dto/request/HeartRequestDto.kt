package org.sopt.cds29cm.data.dto.request


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeartRequestDto(
    @SerialName("memberId")
    val memberId: Long,
    @SerialName("productId")
    val productId: Long
)