package org.sopt.cds29cm.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestHeartDTO(
    @SerialName("memberId")
    val memberId: Long,
    @SerialName("productId")
    val productId: Long,
)
