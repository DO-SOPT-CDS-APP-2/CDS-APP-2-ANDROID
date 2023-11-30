package org.sopt.cds29cm.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseHeartDTO(
    @SerialName("isMade")
    val isMade: Boolean,
)